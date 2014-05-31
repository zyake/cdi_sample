package my.apps.cdi.sample.interceptor;

import javax.ejb.Stateless;

/**
 * インターセプターのバインド対象のセッション・ビーン。
 */
@MyInterceptorBinding
@Stateless
public class Interceptee {

    public String invoke() {
        return "Invoked!";
    }
}
