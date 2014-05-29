package foo.bar;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Admin on 28.05.14.
 */
public class FilterByDate  extends Filter  implements Serializable {
    private Date date;
    public FilterByDate(Date date, Filter filter) {
        super(filter);
        this.date=date;
    }

    @Override
    public boolean isValidate(Event event) {
        return event.isInTime(date) &&
          super.isValidate(event);
    }
}