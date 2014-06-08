package my.apps.cdi.sample.interceptor;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * インターセプターを識別するためのバインディングを定義します。
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME) // 実行時に必要なため、RUNTIMEとします。
public @interface MyInterceptorBinding {
}
