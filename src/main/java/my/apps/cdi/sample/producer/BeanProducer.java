package my.apps.cdi.sample.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ビーンのプロデューサ。
 *
 * <p>
 * プロデューサのライフサイクル系アノテーションが
 * {@link javax.enterprise.context.Dependent}の場合、
 * ビーンの生成毎にインスタンスが破棄され非効率なので、
 * 特に理由が無い限りは、
 * {@link javax.enterprise.context.ApplicationScoped},
 * {@link javax.inject.Singleton},
 * {@link javax.ejb.Singleton}
 * のうちの何れかで定義すべきです。
 * </p>
 */
@ApplicationScoped
public class BeanProducer {

    private static AtomicInteger counter = new AtomicInteger();

    /**
     * {@link javax.enterprise.inject.Produces}で
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
     * {@link javax.enterprise.inject.Produces}で
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
