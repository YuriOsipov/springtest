package foo.bar;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Admin on 27.05.14.
 */
public class EventFullDay extends  Event {
    public EventFullDay(String id, String title, String[] attenders, Date dateStart, Date dateEnd) {
        super(id, title, attenders, dateStart, dateEnd);
    }
    @Override
    public String toString() {
        return super.toString() + " is fullday";
    }
}
