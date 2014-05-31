package my.apps.cdi.sample.producer;

import org.junit.Test;

import javax.naming.NamingException;
import java.util.Date;

import static my.apps.cdi.sample.EmbeddedEJBContainerManager.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProducerTest {

    @Test
    public void testProducerMethod() throws NamingException {
        ProducedBeanInjectee injectee = lookup(
                "java:global/classes/ProducedBeanInjectee");

        ProducedBean producedBean = injectee.getProducedBean();
        assertEquals("ProducedBean: instance count=1", producedBean.getName());
    }

    @Test
    public void testProducerField() throws NamingException {
        BeanCreationDateInjectee injectee = lookup(
                "java:global/classes/BeanCreationDateInjectee");

        Date creationDate = injectee.getCreationDate();
        assertNotNull(creationDate);
    }
}
