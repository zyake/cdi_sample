package my.apps.cdi.sample.scope;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CDIのスペック上は一言も言及がありませんが、シングルトンを
 * 明確に定義できるのは別の仕様の{@link javax.inject.Singleton}を
 * 使う必要があります。
 */
@Singleton
public class SingletonScopeBean {

    private static AtomicInteger counter = new AtomicInteger();

    private String name;

    @PostConstruct
    private void initialize() {
        this.name = "Singleton Scoped: instance count=" + counter.incrementAndGet();
    }

    public String getName() {
        return name;
    }
}
