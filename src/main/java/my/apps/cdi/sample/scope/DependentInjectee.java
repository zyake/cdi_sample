package my.apps.cdi.sample.scope;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DependentInjectee {

    /**
     * {@link javax.inject.Qualifier}が指定されていないので、
     * スキャンされたManaged Beanのうち、
     * 代入可能なManaged Beanがインジェクトされる。
     *
     * もちろん、同一インターフェースに対する実装が複数存在する場合は、
     * Qualifierが指定されていないと、曖昧さを解決できずにエラーとなるので、
     * 要注意!
     */
    @Inject
    private DependentScopeBean testBean1;

    @Inject
    private DependentScopeBean testBean2;


    public DependentScopeBean getDependentBean1() {
        return testBean1;
    }

    public DependentScopeBean getDependentBean2() {
        return testBean2;
    }
}
