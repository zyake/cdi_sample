package my.apps.cdi.sample.interceptor;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * インターセプタークラス。
 *
 * <p>
 * バインディングのアノテーションにより、インターセプト対象を一意に識別します。
 * インターセプターはCDIとは別仕様なので、詳細な有効化方法は
 * JSR-318 Interceptors 1.2に記載されています。
 * </p>
 *
 * <p>
 *  Oracleの公式チュートリアルでは、何故かbeans.xmlで定義していますが、
 *  実際はXMLレスで使用可能です。その場合は、インターセプターを
 *  コンテナに認識させるため、スコープ系アノテーションを定義する必要があります。
 *  インターセプターの場合、定義できるスコープは、Dependent固定です。
 *  CDI1.2では、この煩わしさが軽減されており、デフォルトでインターセプターが
 *  スキャン対象となります。
 * </p>
 */
@MyInterceptorBinding // インターセプターを一意に定義します。
@Priority(0) // インターセプターを有効化します。CDIのJSRに書いてない仕様なので要注意!
@Interceptor
@Dependent // インターセプターは標準ではスキャンされないため、明示的にスコープを指定します。
public class MyInterceptor {

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        return "Intercepted " + context.proceed();
    }
}
