package my.apps.cdi.sample.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * デコレータクラス。
 * 対象のクラスの各メソッド呼び出しをデコレートします。
 *
 * <p>
 *  Oracleの公式チュートリアルでは、何故かbeans.xmlで定義していますが、
 *  実際はXMLレスで使用可能です。その場合は、デコレータを
 *  コンテナに認識させるため、スコープ系アノテーションを定義する必要があります。
 *  デコレータの場合、定義できるスコープは、Dependent固定です。
 *  CDI1.2では、この煩わしさが軽減されており、デフォルトでデコレータが
 *  スキャン対象となります。
 * </p>
 *
 * <p>
 *  なお、大量のメソッドが定義されたクラスをデコレートするのに、冗長な実装をする手間を
 *  軽減するためか、デコレータは抽象クラスでも良いことになっています。
 *  (黒魔術をフル活用することを前提とした、豪快な仕様ですね・・・。)
 * </p>
  */
@Priority(0) // デコレータを有効化します。この仕様はCDIのJSRに記述されています。
@Decorator
@Dependent // デコレータはスキャンされないので、明示的にスコープを指定する必要があります。
public class MyDecorator implements Decoratee {

    /**
     * デコレート対象(へのクライアント・プロキシ)。
     * @Delegate付きのプロキシが定義されない場合、
     * スキャン時にエラーとなります。
     *
     * (余談ですが、IntelliJの有料ではこのあたりもサジェストしてくれます。)
     */
    @Delegate
    @Inject
    private Decoratee delegate;

    @Override
    public String invoke() {
        return "Decorated " + delegate.invoke();
    }
}
