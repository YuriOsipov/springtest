package foo.bar;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 * Created by Admin on 24.05.14.
 */
public interface IEventStore extends Remote{
    public LinkedList<Event> getEventByAttender(String attender)throws RemoteException;

    public LinkedList<Event> getEventByTitle(String attender) throws RemoteException;

    public void addEvent (Event event) throws RemoteException;
}
