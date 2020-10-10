/**
 * Abstract class Event
 * Provides the foundation for the different type of Events - Serve, Waiting, Arrival, Overflow
 * 
 * @author Yazdan Basir
 */
public abstract class Event implements Comparable <Event> {
    public int eventTime;
    public int eventType;
    public int waitingEventTimeNeeded = 0;
    
    //static final int ARRIVAL = 2;
    //static final int WAITING = 1;
    static final int SERVE = 0;
    //static final int OVERFLOW = 3;
    
    /**
     * Constuctor for the Event abstract class
     * 
     * @param a int
     * @param b int
     */
    public Event (int a, int b) {
        this.eventTime = a;
        this.eventType = b;
    }
    
    /**
     * CompareTo methods that orders Events based on their arrivalTime
     * If two Events have the same arrivalTime, they are ordered in the following manner:
     * Departure Events (0)
     * Waiting Events (1)
     * Arrival Events (2)
     * Overflow Events (3)
     * 
     * @param e Event
     */
    public int compareTo(Event e) {
        int output;

        output = this.eventTime - e.eventTime;

        if (output == 0) {
            if (this.eventType == Event.SERVE) {
                return -1;

            } else { 
                return this.eventType - e.eventType; 
            }
        }

        return output;
    }
}