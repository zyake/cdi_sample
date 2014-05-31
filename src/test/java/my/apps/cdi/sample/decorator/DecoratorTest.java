package my.apps.cdi.sample.decorator;

import org.junit.Test;

import javax.naming.NamingException;

import static my.apps.cdi.sample.EmbeddedEJBContainerManager.lookup;
import static org.junit.Assert.assertEquals;

public class DecoratorTest {

    @Test
    public void testDecorator() throws NamingException {
        Decoratee decoratee = lookup("java:global/classes/DecorateeImpl");
        assertEquals("Decorated Invoked!", decoratee.invoke());
    }
}
