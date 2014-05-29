package foo.bar;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Admin on 22.05.14.
 */
public class Event implements Serializable{
    private UUID id;
    private String title;
    private String[] attenders;
    private Date dateStart;
    private Date dateEnd;

    public Event(String id, String title, String[] attenders, Date dateStart, Date dateEnd) {
        if (id==null) this.id=UUID.randomUUID();
        else
            this.id = UUID.fromString(id);
        this.title = title;
        this.attenders = attenders;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;

    }
    public  boolean isInTime (Date date) {
     return getDateEnd().compareTo(date)>=0 && getDateStart().compareTo(date)<=0;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAttenders() {
        return attenders;
    }



    public Date getDateStart() {        return dateStart;    }

    public Date getDateEnd() {      return dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (!Arrays.equals(attenders, event.attenders)) return false;
        if (dateEnd != null ? !dateEnd.equals(event.dateEnd) : event.dateEnd != null) return false;
        if (dateStart != null ? !dateStart.equals(event.dateStart) : event.dateStart != null) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (title != null ? !title.equals(event.title) : event.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (attenders != null ? Arrays.hashCode(attenders) : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", attenders=" + Arrays.toString(attenders) +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
