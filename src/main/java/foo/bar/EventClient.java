package foo.bar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;

/**
 * Created by Admin on 27.05.14.
 */
public class EventClient {

    public static void main(String[] args) throws RemoteException{
        ApplicationContext context = new ClassPathXmlApplicationContext("clientApplicationContext.xml");
        IEventStore service = (IEventStore) context.getBean("calendarService");
        System.out.println(service.getEventByAttender("111@mail.ua"));




    }
}
