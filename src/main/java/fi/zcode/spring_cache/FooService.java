/*
 * Copyright (c) 2012 The Finnish Board of Education - Opetushallitus
 *
 * This program is free software:  Licensed under the EUPL, Version 1.1 or - as
 * soon as they will be approved by the European Commission - subsequent versions
 * of the EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at: http://www.osor.eu/eupl/
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * European Union Public Licence for more details.
 */
package fi.zcode.spring_cache;

import java.util.Locale;
import org.springframework.cache.annotation.Cacheable;

/**
 * Same as BarService - using different interface since spring xml caching config is aop bound to BarService interface
 * and dual cache config didn't work so great. :)
 *
 * @author mlyly
 */
public interface FooService {

//    @Cacheable(value = "foo_locale", key = "#localeCode")
    Locale findLocale(String localeCode);

//    @Cacheable(value = "foo_locales")
    Locale[] findLocales();

}
