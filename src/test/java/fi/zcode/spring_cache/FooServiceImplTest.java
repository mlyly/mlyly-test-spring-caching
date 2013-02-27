package fi.zcode.spring_cache;

import com.sun.jmx.remote.util.CacheMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Status;
import net.sf.ehcache.event.CacheManagerEventListener;

/**
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

    @Autowired
    CacheManager cacheManager;

    /**
     * Test of findLocale method, of class FooServiceImpl.
     */
    @Test
    public void testFindLocale() {
        LOG("testFindLocale()...");

        for (int i = 0; i < 10; i++) {
            long ts = System.currentTimeMillis();

            service.findLocale("fi");
            service.findLocale("en");

            ts = System.currentTimeMillis() - ts;
            LOG("Calls took: " + ts + " ms");

            printCacheStats();
        }

        printCacheStats();

        LOG("testFindLocale()... done.");
    }

    /**
     * Test of findLocales method, of class FooServiceImpl.
     */
    @Test
    public void testFindLocales() {
        LOG("testFindLocales()...");
        long ts = System.currentTimeMillis();

        printCacheStats();

        service.findLocales();
        service.findLocales();
        service.findLocales();

        ts = System.currentTimeMillis() - ts;
        LOG("Calls took: " + ts + " ms");

        printCacheStats();

        LOG("testFindLocales()... done.");
    }


    private void printCacheStats() {
        LOG("---------- cache manager = " + cacheManager);

        for (String cacheName : cacheManager.getCacheNames()) {
            LOG("  cacheName=" + cacheName);
            LOG("    stats=" + cacheManager.getCache(cacheName).getStatistics().toString());
        }
    }

    private void LOG(String string) {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - " + string);
    }

}
