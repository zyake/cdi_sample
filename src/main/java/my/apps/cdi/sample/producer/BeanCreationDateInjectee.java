package my.apps.cdi.sample.producer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Stateless
public class BeanCreationDateInjectee {

    /**
     * プロデューサ・フィールドで生成されたオブジェクトを
     * インジェクトします。
     */
    @Named("creationDate")
    @Inject
    private Date creationDate;

    public Date getCreationDate() {
        return creationDate;
    }
}
