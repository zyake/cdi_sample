package my.apps.cdi.sample.event;

import org.junit.Test;

import javax.naming.NamingException;

import java.util.List;

import static my.apps.cdi.sample.EmbeddedEJBContainerManager.lookup;
import static org.junit.Assert.assertEquals;

public class EventTest {

    @Test
    public void testEvent() throws NamingException {
        EventInjectee injectee = lookup("java:global/classes/EventInjectee");

        // イベントを発行します。
        injectee.getNotifier().fire("Event!");

        List<EventArgument> receivedArgs = injectee.getReceiver().getReceivedArgs();
        assertEquals(1, receivedArgs.size());
        assertEquals("Event!", receivedArgs.get(0).getMessage());
    }

    @Test
    public void testTransactionalEvent() throws NamingException {
        EventInjectee injectee = lookup("java:global/classes/EventInjectee");

        // イベントを発行します。
        // トランザクショナルなイベントは、実際の通知のタイミングが、
        // トランザクションの状態の変更のタイミングとなります。
        injectee.getNotifier().fireTransactionally("Transactional Event!");

        List<EventArgument> receivedArgs = injectee.getReceiver().getTransactionalReceivedArgs();
        assertEquals(1, receivedArgs.size());
        assertEquals("Transactional Event!", receivedArgs.get(0).getMessage());
    }
}
