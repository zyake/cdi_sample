package my.apps.cdi.sample.producer;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProducedBeanInjectee {

    /**
     * プロデューサが生成したビーンをインジェクトします。
     */
    @Inject
    private ProducedBean producedBean;

    public ProducedBean getProducedBean() {
        return producedBean;
    }
}
