# Spring method caching

These projects are basicly "private" testing projects so that I can have reminders 
how to implement stuff when I need them. 

These projects are not meant to be "brilliant" - they work for me as reminders.
Hopefully someone may also find them useful.


======================================================================
			 USE AT YOUR OWN RISK
======================================================================




This project contains a simple maven project with two "services" that are wired up with
spring caching.

- FooServiceImpl (implements FooService) service with cache annotations

- BarServiceImpl (implements BarService interface) with no annotations; caching enabled with spring xml configuration.


References and links:
- http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/cache.html
- http://stackoverflow.com/questions/10343885/spring-3-1-cacheable-method-still-executed - ehcache configuration
