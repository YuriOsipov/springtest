package foo.bar;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 22.05.14.
 */
enum EventPrefix {TITLE,ATTENDER}

public class EventStore implements  IEventStore{

    private HashMap<EventKey,LinkedList<Event>> events = new HashMap();
    private EventKey key =new EventKey();

    public EventStore() {
    }

    public LinkedList<Event> getEventByTime(Date date) {
        return null;
    };

    public LinkedList<Event> getEventByAttender (String attender) {
        key.setValue(EventPrefix.ATTENDER,attender);
       return  events.get(key);
    }

    public LinkedList<Event> getEventByTitle (String attender) {
        key.setValue(EventPrefix.TITLE,attender);
        return  events.get(key);
    }
    private LinkedList<Event> getList (EventKey key, Event event) {
        LinkedList<Event> result = null;
        result = events.get(key);
        if(result == null)   result = new LinkedList();
        result.add(event);
        return  result;
    }
    public void   addEvent (Event event) {
          key.setValue(EventPrefix.TITLE,event.getTitle());
           events.put(key,getList(key,event));

      for (String attender :event.getAttenders()) {
          key.setValue(EventPrefix.ATTENDER,attender);
          events.put(key,getList(key,event));
      }
    }



}
