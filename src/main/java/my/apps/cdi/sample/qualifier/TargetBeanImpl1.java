package my.apps.cdi.sample.qualifier;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * アノテーションにより、特定の実装に依存せずに
 * オブジェクトの識別子を定義します。
 */
@Impl1Qualifier
@Singleton
public class TargetBeanImpl1 implements TargetBean {
}
