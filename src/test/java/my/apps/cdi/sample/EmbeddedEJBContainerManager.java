package my.apps.cdi.sample;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 * 組み込みEJBコンテナの管理クラス。
 */
public class EmbeddedEJBContainerManager {

    /**
     * GlassFishの組み込みEJBコンテナの起動は遅いので、
     * コンテナのインスタンスを全テストケースで使いまわします。
     */
    static EJBContainer container = EJBContainer.createEJBContainer();

    /**
     * JVM毎に一意なテスト用組み込みEJBコンテナからEJBを取得します。
     * @param id
     * @param <T>
     * @return
     */
    public static <T> T lookup(String id) {
        try {
            return (T) container.getContext().lookup(id);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
