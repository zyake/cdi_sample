package my.apps.cdi.sample.qualifier;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 独自のQualifierを定義します。
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)  // RUNTIMEで必要! デフォルトはCLASSです。
public @interface Impl2Qualifier {
}
