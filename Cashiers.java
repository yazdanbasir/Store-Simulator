import java.util.*;

/**
 * Creates an array to keep tracker of Cashier objects
 * Provides functionality to generate random serving time and profit for each customer
 *
 * @author Yazdan Basir
 */
public class Cashiers {
    Cashier[] tracker; // Will hold the Cashier objects to be managed
    
    public int SERVETIME_LOWBOUND;
    public int SERVETIME_HIGHBOUND;
    
    public float PROFIT_HIGHBOUND;
    public float PROFIT_LOWBOUND;
    
    public float totalProfit = 0; // Variable to hold total profit

    // Linked List to hold the cashier free up times
    public LinkedList <Integer> times = new LinkedList <Integer> ();

    /**
     * Constructor for the Cashiers class
     * 
     * @param s int
     * @param lowS int
     * @param highS int
     * @param lowP float
     * @param highP float
     */
    public Cashiers(int s, int lowS, int highS, float lowP, float highP) {
        tracker = new Cashier[s];
        
        SERVETIME_LOWBOUND = lowS;
        SERVETIME_HIGHBOUND = highS;
        
        PROFIT_LOWBOUND = lowP;
        PROFIT_HIGHBOUND = highP;

        // Every Cashier is initialized to true at the start to indicate they are free to serve
        for (int i = 0; i < tracker.length; i++) {
            tracker[i] = new Cashier(true);
        }
    }
    
    /**
     * Generates a random profit between the bounds
     */
    public float generateRandomProfit() {
        Random random = new Random(System.nanoTime());

        return (PROFIT_LOWBOUND + random.nextFloat() * (PROFIT_HIGHBOUND - PROFIT_LOWBOUND));
    }
    
    /**
     * Generates a random serving time between the bounds
     */
    public int generateRandomServingTime() {
        Random random = new Random(System.nanoTime());

        return (random.nextInt((SERVETIME_HIGHBOUND-SERVETIME_LOWBOUND)+1) + SERVETIME_LOWBOUND);
    }

    /**
     * Creates each individual instance of a cashier
     * Provides functionality to manage the status of each individual cashier
     *
     * @author Yazdan Basir
     */
    public class Cashier {
        boolean status; // Boolean to hold whether a cashier is free or not
        
        int finishTime; // The time the cashier will be freed up
        int timeNeeded; // The time the cashier will serve the customer
        int arrivalTime; // The time the cashier was assigned the customer

        /**
         * Constructor for the Cashier class
         * 
         * @param s boolean
         */
        public Cashier(boolean s) {
            status = s;
        }

        /**
         * Starts the serving process. Sets the cashier to false to indicate a customer has been assigned
         * Performs various checks and adds the finish time to the Linked List based on the checks
         * 
         * @param arriveTime int
         * @param type int - eventType of the Event
         * @param last int - the Customer's serving time if they were assiged to the waiting queue
         */
        public int startServingCustomer(int arriveTime, int type, int last) {
            if (type == 1) { // If the customer was waiting in the queue don't assign a new serving time as it was assigned beforehand to maintain the order of the queue
                this.timeNeeded = last;
                
            } else {
                // Otherwise generates a random serving time
                this.timeNeeded = generateRandomServingTime();
            }
            
            this.arrivalTime = arriveTime;
            this.status = false; // Flags the cashier as unavailable now
            
            // The time the cashier will be free is the sum of the assignment time and the time needed to serve
            finishTime = arriveTime + this.timeNeeded;
            
            if (type == 1) {
                if (times.contains(last + arriveTime)) {
                    return (last);
                }
            }
            
            // Maintains the values in the Linked List so the customers in the queue wait as less as they can
            for (int i = 0; i < times.size(); i++) {
                
                if (arriveTime >= times.getLast()) {
                    times.clear();
                    times.add(finishTime);
                
                } else if (arriveTime >= times.peek()) {
                    times.pop();
                }
            }

            // If the Linked List is empty, just add the finish time without any check
            if (times.size() == 0 ) {
                times.add(finishTime);
                return timeNeeded;
            }

            // If the value fits according to the last value, then we can add it to the Linked List
            if (!(finishTime <= times.getLast())) {
                times.add(finishTime);
                return timeNeeded;
            }
            
            return timeNeeded; // Returns the serving time needed for this cashier
        }

        /**
         * Flags the cashier back to true to indicate they are free to serve again
         * Generates a random profit made from this customer
         */
        public void finishServingCustomer() {
            this.status = true;
            totalProfit = totalProfit + generateRandomProfit();
        }
    }
}