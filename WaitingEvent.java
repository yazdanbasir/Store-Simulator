/**
 * Creates an instance of Event where a customer is to join the queue and wait their turn
 *
 * @author Yazdan Basir
 */
public class WaitingEvent extends Event {
    public int eventTime;
    public int eventType;
    public int waitingEventTimeNeeded = 0;

    public WaitingEvent(int a) {
        super(a, 1);
    }
}