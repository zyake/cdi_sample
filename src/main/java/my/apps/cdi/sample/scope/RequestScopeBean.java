package my.apps.cdi.sample.scope;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * リクエストの処理の間がライフサイクルとなるスコープ。
 * <ul>
 *     <li>Servletの1リクエストの処理</li>
 *     <li>EJBのリモート呼び出し、非同期呼び出し、タイマーコールバック</li>
 *     <li>@PostCostructのコールバック</li>
 * </ul>
 *
 * <p>
 * CDIの仕様では、オブジェクトはコンテナが管理し、
 * そのオブジェクトを使うクライアントは、クライアント・プロキシを
 * 通して使用する。
 *
 * そのため、アプリケーション・スコープのビーンに
 * リクエスト・スコープのビーンをインジェクトしても、
 * きちんとリクエスト毎のコンテキストに属する
 * オブジェクトを操作できるので要注意。
 * </p>
 */
@RequestScoped
public class RequestScopeBean {

    private static AtomicInteger counter = new AtomicInteger();

    private String name;

        public RequestScopeBean() {
            // クライアント・プロキシのインスタンス生成時に
            // コンストラクタが呼ばれる(!!!)ので要注意!
            // よく考えないと、無駄に負荷が増えるし、
            // 破綻する可能性があります。
            (new Exception()).printStackTrace();
    }

    @PostConstruct
    private void initialize() {
        this.name = "Request Scoped: instance count=" + counter.incrementAndGet();
    }

    public String getName() {
        return name;
    }
}
