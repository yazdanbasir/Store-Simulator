/**
 * Creates an instace of an Event where a customer enters the shop
 *
 * @author Yazdan Basir
 */
public class ArrivalEvent extends Event {
     int eventTime;
     int eventType;

    public ArrivalEvent(int a) {
        super(a,2);
    }
}