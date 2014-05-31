package my.apps.cdi.sample.scope;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class SingletonScopeInjectee {

    /**
     * シングルトンなので、それぞれのオブジェクトは同一の
     * ビーン(への参照のプロキシ)がインジェクトされます。
     */
    @Inject
    private SingletonScopeBean testBean1;

    @Inject
    private SingletonScopeBean testBean2;

    public SingletonScopeBean getTestBean1() {
        return testBean1;
    }

    public SingletonScopeBean getTestBean2() {
        return testBean2;
    }

    public void printBean1Class() {
        System.out.println(testBean1.getClass().getName());
    }
}
