import java.util.*;
import java.io.*;

/**
 * Runs the simulation and provides functionality for event handling
 *
 * @author Yazdan Basir
 */
public class Simulation {
    Cashiers c; // Instance of Cashiers whose inner class is Cashier
    CustomerQueue cq;
    
    Event currentEvent; // The current Event being looked it in the simulation
    
    PriorityQueue <Event> eventHandler;

    int g; // Arbitrary variable to hold values here and there 
    int queue; // How many customers are waiting in line
    int served; // How many customers have been served
    int lastSave; // The last serving time assigned, used for waiting customers
    int overflow; // How many customers have been lost to overflow
    int maxWaitTime; // The comparable maximum waiting time for a customer
    int totalWaitTime; // The total waiting time of all the customers
    int numberOfCashiers;
    int availableCashiers;
    
    float totalCost;
    float avgWaitTime;

    /**
     * Constructor for the Simulation class
     * 
     * @param s int
     */
    public Simulation(int s) {
        eventHandler = new PriorityQueue <Event> ();
        
        numberOfCashiers = s;
        availableCashiers = numberOfCashiers;

        cq = new CustomerQueue(); 
        cq.getDataFromFile(); // Reads the input file and assigns the data to variables, creates Customer objects
        
        totalCost = cq.CASHIER_WAGE * numberOfCashiers;
        
        // Creates an instance of Cashiers which creates the individual Cashier objects
        c = new Cashiers(s, cq.getLowSBound(), cq.getHighSBound(), cq.getLowPBound(), cq.getHighPBound());

        // Adds the first Customer to the Priority Queue to start the eventHandler
        nextArrivalEvent(cq.peek().arrivalTime);
        cq.pop();
    }

    /**
     * Runs the simulation and returns the data at the end
     */
    public String run() {
        try {
            if (numberOfCashiers == 0) {
                return "All cashiers are busy social-distancing right now." + "\n" +
                "None of them showed up for work today! Goodbye!";
            }
            
            currentEvent = null;

            File outputFile = new File("Simulation Log.txt"); // Creates a new file in the package for the event progression to be seen

            outputFile.createNewFile();

            PrintWriter writeFile = new PrintWriter(outputFile);

            while (!eventHandler.isEmpty()) {
                currentEvent = eventHandler.remove(); // Handles the Event at the top of the Priority Queue
                
                writeFile.print("A customer has entered the shop at time " + currentEvent.eventTime);
                writeFile.println();
               
                if (currentEvent.eventType == 0) { // If a customer needs to be served
                    finishServingCustomer(); // Cashier is freed up, profit is made, cashier can leave

                    served++; // Total customers served incremented
                    availableCashiers++; // One more cashier has been freed up now

                    writeFile.print("A customer has been served at time " + currentEvent.eventTime);
                    writeFile.println();

                } else if (currentEvent.eventType == 2) { // If a customer has just entered the shop

                    if (availableCashiers == 0 || queue > 0) { // If no cashier is available or there is a waiting line

                        if (queue >= 8 * numberOfCashiers) { // If queue is at max size, the customer is turned away
                            overflow++; // Increments the number of customers turned away
                            
                            writeFile.print("Overflow. A customer has been turned away");
                            writeFile.println();

                        } else if (queue < 8 * numberOfCashiers) { // If queue not at max size, the customer is added to the queue
                            int a = nextAvailableServeTime(); // The earliest time the next cashier will be ready to serve this customer

                            queue++; // Number of people in the queue is incremented 

                            writeFile.print("Customer who entered at " + currentEvent.eventTime + " will join queue till " + a); 
                            writeFile.println();

                            g = c.generateRandomServingTime(); // For easier management of events, customers who have to wait have their serving time generated here
                            
                            nextWaitingEvent(a); // The customer is added as a waiting event
                            
                            int b = a - currentEvent.eventTime;
                            
                            if (b > maxWaitTime) {
                                maxWaitTime = b;
                            }
                            
                            totalWaitTime = totalWaitTime + b; // Their waiting time is added to the total
                    
                            c.times.add(a + g); // The time the cashier will finish serving them is added to the Linked List
                        }

                    } else { // If a cashier is available then just directly assign the customer and serve them
                        int ff = startServingCustomer(currentEvent.eventTime);
                        nextDepartureEvent(currentEvent.eventTime + ff);
                        
                        if (queue > 0) { queue--; } // If the customer came from the queue, decrement the number of people waiting 
                        
                        availableCashiers--; // Decrease the cashiers available by 1 because a cashier has just been assigned
                    }

                } else if (currentEvent.eventType == 1) { // If a customer was waiting is line 
                    
                    if (availableCashiers > 0) { // Considers the customers who were at the start of the waiting line
                        int ff = startServingCustomer(currentEvent.eventTime); // Loads their event into the Queue
                        nextDepartureEvent(currentEvent.eventTime + ff);

                        if (queue > 0) { queue--; } 
                        availableCashiers--;
                    
                    } else if (availableCashiers == 0) {
                        int a = nextAvailableServeTime();
                        
                        nextWaitingEvent(a); // Keeps the customer waiting if they were not at the front of the queue
                        
                        int b = a - currentEvent.eventTime;
                            
                        if (b > maxWaitTime) {
                            maxWaitTime = b; // Checks if this wait time was the maximum one
                        }
                            
                        totalWaitTime = totalWaitTime + b; // Adds the time to the total wait time
                    }
                }

                if (cq.peek().arrivalTime < 54000) { // Doesn't consider customers arriving after closing time
                    nextArrivalEvent(cq.peek().arrivalTime); // Adds the next event for the process to restart
                    cq.pop(); 
                }
            }
           
            writeFile.close(); // Saves the file

        } catch (Exception e) {
            System.out.println("An error has occured in run(): " + e);
        } 
        
        avgWaitTime = totalWaitTime/served;
        
        return
        
        "SHOP CLOSED. SEE YOU TOMORROW!" + "\n" + "\n" +
        "Total customers served today: " + served + "\n" +
        "Customers lost due to overflow: " + overflow + "\n" + "\n" +
        "Maximum time a customer waited: " + maxWaitTime + " seconds" + "\n" +
        "Average time each customer waited: " + avgWaitTime + " seconds" + "\n" + "\n" +
        "Total Profit made: $" + c.totalProfit + "\n" +
        "Net Profit made: $" + (c.totalProfit - totalCost) + "\n" + "\n" +
        "Refer to the Simulation Log for more details!";
    }

    /**
     * Adapter method to bridge Simulation and Cashier and allow management of Cashier status
     */
    public int startServingCustomer(int a) {
        for (int i = 0; i < numberOfCashiers; i++) {

            if (c.tracker[i].status == true) {
                int ff = c.tracker[i].startServingCustomer(a, currentEvent.eventType, currentEvent.waitingEventTimeNeeded);
                return ff; // Returns the time needed for the cashier to serve this customer
            }
        }
        
        return -1000000000;
    }

    /**
     * Adapter method to bridge Simulation and Cashier and allow management of Cashier status
     */
    public void finishServingCustomer() {
        for (int i = 0; i < numberOfCashiers; i++) {

            if (c.tracker[i].status == false) {
                c.tracker[i].finishServingCustomer();
                return;
            }
        }
    }

    /**
     * Returns the earliest time any cashier will be free to serve a waiting customer
     */
    public int nextAvailableServeTime() {
        int min = 100000000;
        int remove = 0;
        int b = 0;
        
        for (int i = 0; i < c.times.size(); i++) {
            if (c.times.get(i) < min) {
                min = c.times.get(i);
                remove = i;
            }
        }
        
        c.times.remove(remove);
        return min; // Returns the smallest time value indicating the earliest any cashier will be freed up to serve again
    }

    /**
     * Adds an Arrival Event instance to the Priority Queue
     * 
     * @param a int
     */
    public void nextArrivalEvent(int a) {
        ArrivalEvent next = new ArrivalEvent(a);
        eventHandler.add(next);
    }

    /**
     * Adds a Departure Event instance to the Priority Queue
     * 
     * @param b int
     */
    public void nextDepartureEvent(int b) {
        DepartureEvent next = new DepartureEvent(b);
        eventHandler.add(next);
    }

    /**
     * Adds a Waiting Event instance to the Priority Queue
     * 
     * @param c int
     */
    public void nextWaitingEvent(int c) {
        WaitingEvent next = new WaitingEvent(c);
        next.waitingEventTimeNeeded = g;
        eventHandler.add(next);
    }

    /**
     * Adds an Overflow Event instance to the Priority Queue
     * 
     * @param d int
     */
    public void nextOverflowEvent(int d) {
        OverflowEvent next = new OverflowEvent(d);
        eventHandler.add(next);
    }
}