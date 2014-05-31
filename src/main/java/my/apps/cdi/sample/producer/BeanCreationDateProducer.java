package my.apps.cdi.sample.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Date;

@Dependent
public class BeanCreationDateProducer {

    /**
     * ビーンの生成日時を供給するプロデューサ・フィールド。
     * この例は極めて単純で、一見何に使うという感じですが、
     * 現実のWebアプリでは、JPAの{@link javax.persistence.EntityManager}
     * をRequestScopedで生成し、コンカレントアクセスを
     * 防ぐのに使われるはずです。EntityManagerの例は
     * 以下のとおりになります。
     * <pre>
     *  @PersistenceContext       // コンテナ管理のEntityManagerをインジェクトします。
     *  @Produces                 // サービスクラスなどにEntityManagerを供給します。
     *  private EntityManager em;
     * </pre>
     */
    @Named("creationDate")
    @Produces
    private Date creationDate = new Date();
}
