package foo.bar;

import java.util.*;

/**
 * Created by Admin on 22.05.14.
 */


public class EventStore implements  IEventStore{

    private ArrayList<Event> events = new ArrayList();


    public EventStore() {
    }


    @Override
    public Collection<Event> getEventByFilter(Filter filter)  {
        Collection<Event> result= new LinkedList<Event>();
       for (Event event:events) {
           if ((filter!=null)&&(filter.isValidate(event)))
                   result.add(event);
       }
        return  result;
    }

  public boolean isAttenderAvailable (String attender,Date date){
      FilterByDate filterByDate = new FilterByDate(date,null);
      FilterByAttender filterByAttender = new FilterByAttender(attender,filterByDate);
      return  getEventByFilter(filterByAttender).size()==0;
  }

    public Date getAvailableTime (Date date) {
        FilterByDate filterByDate = new FilterByDate(date,null);
        getEventByFilter(filterByDate);
    }

    public void   addEvent (Event event) {
         events.add(event);
      }
    }




