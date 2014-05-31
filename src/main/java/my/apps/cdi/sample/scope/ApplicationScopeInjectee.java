package my.apps.cdi.sample.scope;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ApplicationScopeInjectee {

    @Inject
    private ApplicationScopeBean testBean1;

    @Inject
    private ApplicationScopeBean testBean2;

    public ApplicationScopeBean getTestBean1() {
        return testBean1;
    }

    public ApplicationScopeBean getTestBean2() {
        return testBean2;
    }

    public void printBean1Class() {
        System.out.println(testBean1.getClass().getName());
    }
}
