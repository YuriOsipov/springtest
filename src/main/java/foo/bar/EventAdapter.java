package foo.bar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Admin on 29.05.14.
 */
@XmlRootElement
public class EventAdapter implements Serializable {

    private UUID id;
    private String title;
    private String[] attenders;
    private Date dateStart;
    private Date dateEnd;

        public EventAdapter() {
        }

        public EventAdapter(Event event) {
            this.id = event.getId();
            this.title = event.getTitle();
            this.attenders = event.getAttenders();
            this.dateStart = event.getDateStart();
            this.dateEnd = event.getDateEnd();
        }
    public Event getEvent() {
     return new Event(getId().toString(),getTitle(),getAttenders(),getDateStart(),getDateEnd());
    }

    public UUID getId() {
        return id;
    }
    @XmlElement
    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAttenders() {
        return attenders;
    }
    @XmlElement
    public void setAttenders(String[] attenders) {
        this.attenders = attenders;
    }

    public Date getDateStart() {
        return dateStart;
    }
    @XmlElement
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }
    @XmlElement
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
