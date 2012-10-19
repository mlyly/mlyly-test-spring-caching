package fi.zcode.spring_cache;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author mlyly
 */
@ContextConfiguration(locations = {
    "classpath:test-context.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class FooServiceImplTest {

    private static final Logger LOG = Logger.getAnonymousLogger();

    @Autowired(required = true)
    private FooServiceImpl service;

    /**
     * Test of findLocale method, of class FooServiceImpl.
     */
    @Test
    public void testFindLocale() {
        LOG.info("testFindLocale()...");

        for (int i = 0; i < 10; i++) {
            long ts = System.currentTimeMillis();

            service.findLocale("fi");
            service.findLocale("en");

            ts = System.currentTimeMillis() - ts;
            LOG.log(Level.INFO, "Calls took: {0} ms", ts);
        }

        LOG.info("testFindLocale()... done.");
    }

    /**
     * Test of findLocales method, of class FooServiceImpl.
     */
    @Test
    public void testFindLocales() {
        LOG.info("testFindLocales()...");
        long ts = System.currentTimeMillis();

        service.findLocales();
        service.findLocales();
        service.findLocales();

        ts = System.currentTimeMillis() - ts;
        LOG.log(Level.INFO, "Calls took: {0} ms", ts);

        LOG.info("testFindLocales()... done.");
    }
}
