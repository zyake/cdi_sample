package my.apps.cdi.sample.event;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class EventReceiver {

    private final List<EventArgument> receivedArgs = new ArrayList<EventArgument>();

    private final List<EventArgument> transactionalReceivedArgs = new ArrayList<EventArgument>();

    /**
     * イベントのオブザーバ・メソッド。
     * EventQualifierで修飾されたNotifierからのイベントを受信します。
     * @param arg
     */
    public void receiveEvent(@Observes @EventQualifier EventArgument arg) {
        receivedArgs.add(arg);
    }

    /**
     * トランザクション完了時にイベントを受信するレシーバ。
     * 受信のタイミングがトランザクション完了時なので、イベントの通知と、
     * オブザーバ・メソッドの呼び出しタイミングが変わります。
     * 成功時のみ、失敗時のみなど、細かく指定可能です。
     * @param arg
     */
    public void receiveTransactionalEvent(
            @Observes(during = TransactionPhase.AFTER_COMPLETION)
            @TransactionalEventQualifier EventArgument arg) {
        System.out.println("Transactional Event Received!: msg=" + arg.getMessage());
        transactionalReceivedArgs.add(arg);
    }

    public List<EventArgument> getReceivedArgs() {
        return receivedArgs;
    }

    public List<EventArgument> getTransactionalReceivedArgs() {
        return transactionalReceivedArgs;
    }
}
