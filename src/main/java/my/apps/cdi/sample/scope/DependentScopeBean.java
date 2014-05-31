package my.apps.cdi.sample.scope;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * デフォルトのDependentのスコープで定義する。
 *
 * <p>
 *     @Dependentを定義しなくても、暗黙的にDependentスコープだが、
 *     CDI1.1でbeans.xmlを使用しないbean discovery modeのデフォルト動作の仕様により、
 *      スコープか、セッションビーンのアノテーションが必須である。
 * </p>
 *
 * <p>
*     また、Dependentの場合、インジェクト先のビーンのコンテキストに属する。
*     Produerのように、特定のBeanに直接インジェクトされない場合は、
*     コンテナからのコールバック一回毎に生成される。
*     (ただし、Decorator/Interceptorの場合は、対象ビーンとペアとなる)
 * </p>
 */
@Dependent
public class DependentScopeBean {

    private static AtomicInteger counter = new AtomicInteger();

    private String name;

    @PostConstruct
    private void initialize() {
        this.name = "Dependent Scoped: instance count=" + counter.incrementAndGet();
    }

    public String getName() {
        return  name;
    }
}
