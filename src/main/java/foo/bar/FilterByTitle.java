package foo.bar;

import java.io.Serializable;

/**
 * Created by Admin on 28.05.14.
 */
public class FilterByTitle extends Filter  implements Serializable {
    private  String title;
    public FilterByTitle(String title, Filter filter) {
        super(filter);
        this.title=title;
    }

    @Override
    public boolean isValidate(Event event) {
        return event.getTitle().equals(title) &&
          super.isValidate(event);
    }
}
