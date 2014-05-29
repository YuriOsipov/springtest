package foo.bar;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Admin on 28.05.14.
 */

    public class FilterByAttender extends Filter  implements Serializable {
        private  String attender;
        public FilterByAttender(String attender, Filter filter) {
            super(filter);
            this.attender=attender;
        }
        private boolean isContains(String[] list, String value) {
            boolean result=false;
            int i=0;
            while (!result && i<list.length) {
                result=value.equals(list[i++]);
            }
            return result;
        }

        @Override
        public boolean isValidate(Event event) {
            return isContains(event.getAttenders(),attender) &&  super.isValidate(event);
        }
    }