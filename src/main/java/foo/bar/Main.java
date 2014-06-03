package foo.bar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IEventStore eventStore = (IEventStore) context.getBean("eventStore");
//        Event first = (Event) context.getBean("first");
//        Event second = (Event) context.getBean("second");

//        eventStore.addEvent(first);
//        eventStore.addEvent(second);
//        eventStore.saveAllEvents();





    }
}
