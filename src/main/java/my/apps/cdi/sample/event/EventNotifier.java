package my.apps.cdi.sample.event;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Date;

@Singleton
public class EventNotifier {

    /**
     * イベントの通知に使うインターフェースをインジェクトします。
     * 通知先などはQualifierで一意に識別します。
     */
    @EventQualifier
    @Inject
    private Event<EventArgument> event;

    @TransactionalEventQualifier
    @Inject
    private Event<EventArgument> transactionalEvent;

    public void fire(String msg) {
        event.fire(new EventArgument(new Date(), msg));
    }

    /**
     * トランザクショナルにイベントを通知します。
     * 通常のイベントと異なり、オブザーバが即時にイベントを受信せずに、
     * トランザクションの動作とリンクします。
     */
    @Transactional
    public void fireTransactionally(String msg) {
        transactionalEvent.fire(new EventArgument(new Date(), msg));

        // このメッセージの後にトランザクションの処理が完了してからイベントが通知されます。
        System.out.println("end transactional method");
    }
}
