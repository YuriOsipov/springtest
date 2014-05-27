package foo.bar;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Admin on 22.05.14.
 */
public class Event implements Serializable{
    private UUID id;
    private String title;
    private String[] attenders;

    private Event(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.attenders = builder.attenders;
    }

    public Event(String id, String title, String[] attenders) {
        if (id==null) this.id=UUID.randomUUID();
        else
        this.id = UUID.fromString(id);
        this.title = title;
        this.attenders = attenders;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (attenders != null ? !attenders.equals(event.attenders) : event.attenders != null) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (title != null ? !title.equals(event.title) : event.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", attenders=" + Arrays.toString(attenders) +
                '}';
    }


    public static class Builder {
        private UUID id;
        private String title;
        private String[] attenders;

        public Builder() {
        }

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAttenders(String[] attenders) {
            this.attenders = attenders;
            return this;
        }

        public Event  build () {
            return new Event(this);
        }
    }
}
