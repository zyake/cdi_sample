package my.apps.cdi.sample.decorator;

import javax.ejb.Stateless;

/**
 * デコレート対象のクラス。インターフェースの実装である必要があります。
 */
@Stateless
public class DecorateeImpl implements Decoratee {

    @Override
    public String invoke() {
        return "Invoked!";
    }
}
