package my.apps.cdi.sample.event;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * イベントを識別するためのQualifierを定義します。
 * インターセプターと異なり、特別なアノテーションは必要ありません。
 */
@Qualifier
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EventQualifier {
}
