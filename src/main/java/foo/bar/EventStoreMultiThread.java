package foo.bar;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Admin on 03.06.14.
 */
public class EventStoreMultiThread extends EventStore {

    public EventStoreMultiThread() throws JAXBException, IOException {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 3);
        service.execute(new Runnable() {
            public void run()  {
                try {
                    LoadEvents();
                }
                catch (IOException  e) {};

            }
        }
        );
    }



}
