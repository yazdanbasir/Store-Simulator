/**
 * Creates the Event where a Customer has been served and is ready to leave
 *
 * @author Yazdan Basir
 */
public class DepartureEvent extends Event {
    public int eventTime;
    public int eventType;

    public DepartureEvent(int a) {
        super(a, 0);
    }
}