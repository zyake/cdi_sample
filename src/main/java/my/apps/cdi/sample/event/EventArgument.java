package my.apps.cdi.sample.event;


import java.util.Date;

/**
 * イベントの通知に使うオブジェクト。
 */
public class EventArgument {

    private final Date eventDate;

    private final String message;

    public EventArgument(Date eventDate, String message) {
        this.eventDate = eventDate;
        this.message = message;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "EventArgument{" +
                "eventDate=" + eventDate +
                ", message='" + message + '\'' +
                '}';
    }
}
