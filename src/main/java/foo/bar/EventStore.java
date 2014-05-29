package foo.bar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.awt.print.Book;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Created by Admin on 22.05.14.
 */


public class EventStore implements  IEventStore{

    private ArrayList<Event> events = new ArrayList();


    public EventStore() throws JAXBException,IOException{
        LoadEvents();
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
        return  null;
    }

    public void   addEvent (Event event) {
         events.add(event);
      }

    public  void saveEvent (Event event) {
        JAXBContext context = null;

        EventAdapter eventAdapter = new EventAdapter(event);
        try {
            context = JAXBContext.newInstance(EventAdapter.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(eventAdapter, new File("d:\\temp\\"+ eventAdapter.getId() +". xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public  void saveAllEvents (){
     for (Event event : events)
         saveEvent(event);
    }


    public  void LoadEvents () throws  IOException{
           String ROOT = "d:\\temp\\";
           FileVisitor<Path> fileProcessor = new ProcessFile();
           Files.walkFileTree(Paths.get(ROOT), fileProcessor);
    }
    public void LoadEvent (Path aFile) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(EventAdapter.class);
        Unmarshaller um = context.createUnmarshaller();
        EventAdapter eventAdapter = (EventAdapter) um.unmarshal(aFile.toFile());
        addEvent(eventAdapter.getEvent());
    }

    private  final class ProcessFile extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult visitFile(Path aFile, BasicFileAttributes aAttrs) throws  IOException {
                try {
                    LoadEvent(aFile);                }
                catch (JAXBException e){  System.out.println("Error read file:" + aFile.toFile());}
                return FileVisitResult.CONTINUE;
            }

    }

}




