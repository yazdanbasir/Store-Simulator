/**
 * Creates an instance of an Event where a customer has been turned away
 *
 * @author Yazdan Basir
 */
public class OverflowEvent extends Event {
    public int eventTime;
    public int eventType;

    public OverflowEvent(int a) {
        super(a, 3);
    }
}