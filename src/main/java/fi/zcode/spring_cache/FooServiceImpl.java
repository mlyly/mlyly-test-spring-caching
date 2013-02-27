package fi.zcode.spring_cache;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * A service with cache annotations in the interface.
 * NOTE - no interface implemented because spring xml caching configuration is aop bound to MyService interface methods.
 *
 * @author mlyly
 */
@Component
@Configurable
public class FooServiceImpl implements FooService  {

    private static final Logger LOG = Logger.getAnonymousLogger();

    @Cacheable(value="foo_locale", key="#localeCode")
    @Override
    public Locale findLocale(String localeCode) {
        LOG.log(Level.INFO, "findLocale({0})", localeCode);

        doDelay();
        for (Locale locale : Locale.getAvailableLocales()) {
            if (locale.getLanguage().equalsIgnoreCase(localeCode)) {
                return locale;
            }
        }

        return null;
    }

    @Cacheable(value="foo_locales")
    @Override
    public Locale[] findLocales() {
        LOG.info("findLocales()");
        doDelay();
        return Locale.getAvailableLocales();
    }

    private void doDelay() {
        // Simulate loong operation
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException ex) {
            LOG.info("interrupted!");
        }
    }

}
