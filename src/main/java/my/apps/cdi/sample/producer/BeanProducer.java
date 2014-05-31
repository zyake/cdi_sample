package my.apps.cdi.sample.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class BeanProducer {

    private static AtomicInteger counter = new AtomicInteger();

    /**
     * プロデューサ・メソッドを定義します。
     * デフォルトのスコープはDependentになります。
     * また、Qualifierを指定可能です。
     * @return
     */
    @Named("count")
    @Produces
    private int incrementAndGet() {
        return counter.incrementAndGet();
    }

    /**
     * プロデューサ・メソッドを定義します。
     * メソッドにスコープ・アノテーションを定義することで、
     * 生成されるオブジェクトのライフサイクルを決定します。
     * また、パラメータはインジェクション・ポイントになります。
     * @param count
     * @return
     */
    @ApplicationScoped
    @Produces
    public ProducedBean produceBean(@Named("count") int count) {
        return new ProducedBean("ProducedBean: instance count=" + count);
    }
}
