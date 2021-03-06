package fi.zcode.spring_cache;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A service with no cache annotations.
 * Caching is added via spring xml-configuration and bound to BarService interface with aop.
 *
 * @author mlyly
 */
public class BarServiceImpl implements BarService {

    private static final Logger LOG = Logger.getAnonymousLogger();

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
