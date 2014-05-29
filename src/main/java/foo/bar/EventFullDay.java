package foo.bar;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Admin on 27.05.14.
 */
public class EventFullDay extends  Event {
    public EventFullDay(String id, String title, String[] attenders, Date dateStart, Date dateEnd) {
//        dateStart.setTime(0);
//        dateEnd=dateStart;
//        dateEnd.setTime(1000*60*60*24);
        super(id, title, attenders, dateStart, dateEnd);

    }
    @Override
    public String toString() {
        return super.toString() + " is fullday";
    }

    private boolean isSameDate (Date a, Date b){
        return  (a.getDate() == b.getDate() &&
                a.getMonth() == b.getMonth() &&
                a.getYear() == b.getYear());
    }
    @Override
    public boolean isInTime(Date date) {
        return isSameDate(getDateStart(),date);
    }
}
