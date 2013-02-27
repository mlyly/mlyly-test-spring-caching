package fi.zcode.spring_cache;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author mlyly
 */
@ContextConfiguration(locations = {
        "classpath:test-context.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class FooServiceImplTest {

    @Autowired
    private FooService service;

    @Autowired
    CacheManager cacheManager;

    /**
     * Test of findLocale method, of class FooServiceImpl.
     */
    @Test
    public void testFindLocale() {
        LOG("testFindLocale()...");

        printCacheStats();

        for (int i = 0; i < 10; i++) {
            long ts = System.currentTimeMillis();

            LOG((i == 0) ? "(fi) First call, service will be called." : "(fi) Not the first call, using cached result... no service call made.");
            service.findLocale("fi");

            LOG((i == 0) ? "(en) First call, service will be called." : "(en) Not the first call, using cached result... no service call made.");
            service.findLocale("en");

            ts = System.currentTimeMillis() - ts;
            LOG("Calls took: " + ts + " ms");
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

        printCacheStats();

        long ts = System.currentTimeMillis();

        LOG("Only first call should actually call the service...");
        service.findLocales();

        LOG("second call... - no service called.");
        service.findLocales();

        LOG("third call... - no service called.");
        service.findLocales();

        ts = System.currentTimeMillis() - ts;
        LOG("Calls took: " + ts + " ms");

        printCacheStats();

        LOG("testFindLocales()... done.");
    }


    private void printCacheStats() {
        LOG("---------- CACHE STATISTICS:");

        for (String cacheName : cacheManager.getCacheNames()) {
            long hits = cacheManager.getCache(cacheName).getStatistics().getCacheHits();
            long misses = cacheManager.getCache(cacheName).getStatistics().getCacheMisses();

            LOG("  cacheName=" + cacheName + ", hits=" + hits + ", misses=" + misses);

            // LOG("    stats=" + cacheManager.getCache(cacheName).getStatistics().toString());
        }
    }

    private void LOG(String string) {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - " + string);
    }

}
