package fi.zcode.spring_cache;

import java.util.Locale;

/**
 * Simple test interface.
 *
 * @author mlyly
 */
public interface MyService {

    Locale findLocale(String localeCode);

    Locale[] findLocales();
}
