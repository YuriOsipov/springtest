package foo.bar;

import java.io.Serializable;

/**
 * Created by Admin on 28.05.14.
 */
abstract class Filter  implements Serializable {
    public Filter getFilter() {
        return filter;
    }



    private Filter filter;

     public boolean isValidate(Event event) {
        return  ((getFilter()!=null)&& (getFilter().isValidate(event))||(getFilter()==null)) ;
     };

    public Filter(Filter filter) {
        this.filter = filter;
    }
}
