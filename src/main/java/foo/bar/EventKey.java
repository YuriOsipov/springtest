package foo.bar;

/**
 * Created by Admin on 24.05.14.
 */

   public  class EventKey {
        private EventPrefix prefix;
        private String value;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof EventKey)) return false;

            EventKey eventKey = (EventKey) o;

            if (prefix != eventKey.prefix) return false;
            if (value != null ? !value.equals(eventKey.value) : eventKey.value != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = prefix != null ? prefix.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }



        public  void setValue(EventPrefix prefix,String value) {
            this.value = value;
        }
    }

