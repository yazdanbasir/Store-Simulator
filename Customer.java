/**
 * Creates each individual Customer object
 *
 * @author Yazdan Basir
 */
public class Customer implements Comparable {
    int arrivalTime; // The time the customer entered the store and joined the queue
    int servingTime; // The time the customer will take to be served by any cashier
    int startOfServingTime; // The time the customer's turn to be served finally comes
    
    /**
     * Constructor for the Customer class
     * 
     * @param a int
     * @param t int
     * @param q int
     */
    public Customer (int a, int t, int q) {
        arrivalTime = a;
        servingTime = t;
        startOfServingTime = q;
    }
    
    /**
     * Helps sort the Customers based on when they came into the store
     * 
     * @param b Object
     */
    public int compareTo(Object b) {
        Integer a = this.arrivalTime;
        Integer c = ((Customer) b).arrivalTime;
        
        return (a.compareTo(c));
    }
}