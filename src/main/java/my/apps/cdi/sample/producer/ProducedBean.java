package my.apps.cdi.sample.producer;

import javax.inject.Inject;

/**
 * 生成対象のビーン。
 *
 * <p>
 * どのスコープに属するかは、プロデューサが決定するため、
 * 生成対象のBeanにスコープを指定する必要はない。
 * 多様な使われ方があり得るライブラリの場合は、
 * CDIへの依存をなるべく排除したほうが良いかもしれません。
 * </p>
 */
public class ProducedBean {

    private final String name;

    public ProducedBean(String name) {
        this.name = name;
    }

    /**
     * プロデューサから生成するには、コンストラクタに@Injectを
     * 指定してインジェクション・ポイントとするか、
     * 引数無しのコンストラクタを指定する必要があります。
     * @Injectを指定する場合は、インジェクトする値を
     * 解決出来る必要があり、極めてややこしいので、
     * なるべくさけるべきかと思います。
     */
    public ProducedBean() {
        this.name = "";
    }

    public String getName() {
        return name;
    }
}
