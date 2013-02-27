package fi.zcode.spring_cache;

import java.util.Locale;

/**
 * Simple test interface to test caching to.
 * No annotations here. see spring xml config how the caching is wired.
 *
 * @author mlyly
 */
public interface BarService {

    Locale findLocale(String localeCode);

    Locale[] findLocales();
}
