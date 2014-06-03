package foo.bar;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Admin on 24.05.14.
 */
public interface IEventStore extends Remote{

    public Collection<Event> getEventByFilter(Filter filter) throws RemoteException;
    public boolean isAttenderAvailable (String attender,Date date) throws RemoteException;
    public Date getAvailableTime (Date date) throws RemoteException;

    public void addEvent (Event event) throws RemoteException;
    public  void saveAllEvents () throws  RemoteException;
    public Boolean isEmpty() throws  RemoteException;
}
