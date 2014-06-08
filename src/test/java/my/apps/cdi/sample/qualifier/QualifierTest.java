package my.apps.cdi.sample.qualifier;

import org.junit.Test;

import javax.naming.NamingException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import static my.apps.cdi.sample.EmbeddedEJBContainerManager.lookup;

public class QualifierTest {

    @Test
    public void testQualifier() throws NamingException {
        Injectee injectee = lookup("java:global/classes/Injectee");
        assertThat(injectee.getTargetBean1(), instanceOf(TargetBeanImpl1.class));
        assertThat(injectee.getTargetBean2(), instanceOf(TargetBeanImpl2.class));
        assertThat(injectee.getTargetBean3(), instanceOf(TargetBeanImpl3.class));
    }
}
