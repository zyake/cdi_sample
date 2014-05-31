package my.apps.cdi.sample.interceptor;

import org.junit.Test;

import javax.naming.NamingException;

import static my.apps.cdi.sample.EmbeddedEJBContainerManager.lookup;
import static org.junit.Assert.assertEquals;

public class InterceptorTest {

    @Test
    public void testInterceptor() throws NamingException {
        Interceptee interceptee = lookup("java:global/classes/Interceptee");
        assertEquals("Intercepted Invoked!", interceptee.invoke());
    }
}
