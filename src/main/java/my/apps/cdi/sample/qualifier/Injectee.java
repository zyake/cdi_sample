package my.apps.cdi.sample.qualifier;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.lang.annotation.Target;

/**
 * インジェクト先のセッション・ビーン。
 * {@link javax.inject.Qualifier}を使用することで、
 * 特定の実装への依存を排除しつつ、
 * インジェクト対象のビーンを識別します。
 */
@Stateless
public class Injectee {

    /**
     * TargetBeanに代入可能なManaged Beanは2つ存在するが、
     * Qualifierにより実装を一意に識別する。
     */
    @Impl1Qualifier
    @Inject
    private TargetBean targetBean1;

    @Impl2Qualifier
    @Inject
    private TargetBean targetBean2;

    /**
     * 文字列でインジェクト対象のビーンを選択します。
     */
    @Named("impl3")
    @Inject
    private TargetBean targetBean3;

    public TargetBean getTargetBean1() {
        return targetBean1;
    }

    public TargetBean getTargetBean2() {
        return targetBean2;
    }

    public TargetBean getTargetBean3() {
        return targetBean3;
    }
}
