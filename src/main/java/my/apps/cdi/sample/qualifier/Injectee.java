package my.apps.cdi.sample.qualifier;

import javax.ejb.Stateless;
import javax.inject.Inject;

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

    public TargetBean getTargetBean1() {
        return targetBean1;
    }

    public TargetBean getTargetBean2() {
        return targetBean2;
    }
}
