package foo.bar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by Admin on 27.05.14.
 */
public class EventClient {

    public static void main(String[] args) throws RemoteException{
        ApplicationContext context = new ClassPathXmlApplicationContext("clientApplicationContext.xml");
        IEventStore service = (IEventStore) context.getBean("calendarService");
        FilterByTitle filterByTitle = new FilterByTitle("second",null);
        FilterByDate filter = new FilterByDate(new Date("2014/05/30 11:30"),null);
        FilterByAttender filterByAttender = new FilterByAttender("111@mail.ua",null);
        System.out.println(service.getEventByFilter(filterByAttender));

        System.out.println(service.isAttenderAvailable("111@mail.ua", new Date("2014/04/30 14:30")));
        //"111@mail.ua"
     // service.saveAllEvents();



    }
}
