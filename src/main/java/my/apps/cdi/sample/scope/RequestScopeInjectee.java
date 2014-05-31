package my.apps.cdi.sample.scope;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.concurrent.Future;

@Stateless
public class RequestScopeInjectee {

    /**
     * リクエスト・スコープのオブジェクトをインジェクトする。
     *
     * <p>
     * インジェクトされるのは、クライアント・プロキシであり、
     * 実体はCDIのプロバイダが管理するため、
     * ライフサイクルが複数リクエストに及ぶ、
     * あるいは平行アクセスされるオブジェクトでも、
     * きちんとリクエスト毎のコンテキストに属する
     * オブジェクトを使用する。
     * </p>
     *
     * <p>
     * 特に平行アクセスが許されない{@link javax.persistence.EntityManager}等を
     * 非セッション・ビーンで扱うときに役に立ちます。
     * (プロデューサ・フィールドと組み合わせると良い)
     * </p>
     */
    @Inject
    private RequestScopeBean testBean;

    /**
     * リクエスト毎のビーンを返す。
     *
     * @return
     */
    @Asynchronous
    public Future<String> getName() {
        return new AsyncResult<String>(testBean.getName());
    }
}
