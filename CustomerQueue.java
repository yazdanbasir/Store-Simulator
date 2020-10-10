import java.util.*;
import java.io.*;

/**
 * Creates an ArrayList to which the customers are added from the data in the file
 *
 * @author Yazdan Basir
 */
public class CustomerQueue {
    ArrayList <Customer> customersList; // Holds the Customer objects
    
    int overflowCount = 0; // Tracks how many customers have been lost due to overflow
    
    /**
     * Constructor for the CustomerQueue class
     * 
     * @param s int
     */
    public CustomerQueue() {
        customersList = new ArrayList <Customer> ();
    }
    
    int SERVETIME_LOWBOUND;
    int SERVETIME_HIGHBOUND;
    
    float PROFIT_HIGHBOUND;
    float PROFIT_LOWBOUND;

    float CASHIER_WAGE;
    
    /**
     * Returns the low bound of the profit from the file
     * According to this file, this should be 2
     */
    public float getLowPBound () {
        return PROFIT_LOWBOUND;
    }
    
    /**
     * Returns the high bound of the profit from the file
     * According to this file, this should be 6
     */
    public float getHighPBound () {
        return PROFIT_HIGHBOUND;
    }
    
    /**
     * Returns the low bound of the serving time from the file
     * According to this file, this should be 60
     */
    public int getLowSBound() {
        return SERVETIME_LOWBOUND;
    }
    
    /**
     * Returns the high bound of the profit from the file
     * According to this file, this should be 240
     */
    public int getHighSBound() {
        return SERVETIME_HIGHBOUND;
    }
    
    /**
     * Goes through the input file and assigns all the data to appropriate variables
     * Creates Customer objects based on the data and adds them to the ArrayList
     */
    public void getDataFromFile() {
        try {
            Scanner readFile = new Scanner(new FileReader("input.txt"));

            // Setting the high & low bound for profit
            
            // Array that holds the two values in the line corresponding to profit bounds
            String [] profitBounds = readFile.nextLine().split(" ");

            PROFIT_LOWBOUND = new Float(profitBounds[0]); // First index is the lower bound
            PROFIT_HIGHBOUND = new Float(profitBounds[1]); // Second index is the upper bound

            // Setting the cashier wage & total cost
            CASHIER_WAGE = new Float(readFile.nextLine()); // The value in the next line corresponds to the cashiers' daily wages

            //totalCost = numberOfCashiers * CASHIER_WAGE; // Total cost is set to cashiers * wage

            // Setting the high & low bound for serve time
            
            // Array that holds the two values in the line corresponding to serving time bounds
            String [] serveTimeBounds = readFile.nextLine().split(" ");

            SERVETIME_LOWBOUND = new Integer(serveTimeBounds[0]); // First index is the lower bound
            SERVETIME_HIGHBOUND = new Integer(serveTimeBounds[1]); // Second index is the upper bound

            // Adding all arrival times into an ArrayList
            while (readFile.hasNext()) {
                // Splits the line into hours, minutes, and seconds
                String [] timeSplit = readFile.nextLine().split(":");

                int hour = (new Integer(timeSplit[0]) - 6) * 60 * 60; // Converts hours to seconds
                int minute = new Integer(timeSplit[1]) * 60; // Converts minutes to seconds
                int seconds = new Integer(timeSplit[2]);

                int a = hour + minute + seconds; // Adds it all up to give us a Customer's arrival time

                // Adds a new Customer with arrivalTime a, a random serving time between the bounds, and 0 as startOfServingTime
                customersList.add(new Customer(a, 0, 0));
            }

        } catch (Exception e) {
            System.out.println("An error has occurred in importData():");
            System.out.println(e);
        }
    }
    
    /**
     * Adds a Customer object to the queue
     * Returns true if added, false otherwise
     * Increments the overflow counter as needed
     * 
     * @param c Customer
     */
    public boolean add(Customer c) {
        return customersList.add(c);
    } 
    
    /**
     * Returns, but doesn't remove, the customer at the top of the queue
     */
    public Customer peek() {
        return customersList.get(0);
    }
    
    /**
     * Removes the customer at the top of the queue
     */
    public void pop() {
        customersList.remove(0);
    }
}