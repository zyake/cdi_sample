package my.apps.cdi.sample.scope;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * アプリケーション・スコープに属するオブジェクトを定義する。
 * <p>
 * 非常にわかりづらいですが、スコープ・アノテーションは
 * 「オブジェクトの属するスコープ」のみを定義するので、
 * シングルトンかどうかとは別です。
 * </p>
 *
 * <p>
 * ServletやJAX-RSなどのUIレイヤのクラスが、
 * 一箇所だけで特定のサービスを参照する場合は、
 * 実質シングルトンと似た挙動となりえますが、
 *
 * EJBとManaged Beanは提供されるサービスが異なるので、
 * 用途応じて使い分けることになるはずです。
 * </p>
 */
@ApplicationScoped
public class ApplicationScopeBean {

    private static AtomicInteger counter = new AtomicInteger();

    private String name;

    @PostConstruct
    private void initialize() {
        this.name = "Application Scoped: instance count=" + counter.incrementAndGet();
    }

    public String getName() {
        return name;
    }
}
