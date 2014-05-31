package my.apps.cdi.sample.event;


import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class EventInjectee {

    @Inject
    private EventNotifier notifier;

    @Inject
    private EventReceiver receiver;

    public EventNotifier getNotifier() {
        return notifier;
    }

    public EventReceiver getReceiver() {
        return receiver;
    }
}
