package my.apps.cdi.sample.qualifier;

import javax.inject.Singleton;

/**
 * アノテーションにより、特定の実装に依存せずに
 * オブジェクトの識別子を定義します。
 */
@Impl2Qualifier
@Singleton
public class TargetBeanImpl2 implements TargetBean {
}
