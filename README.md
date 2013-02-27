# Spring method caching

This project contains a simple maven project with two "services" that are wired up with
spring caching.

- FooServiceImpl (implements FooService) service with cache annotations

- BarServiceImpl (implements BarService interface) with no annotations; caching enabled with spring xml configuration.


References and links:
- http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/cache.html
- http://stackoverflow.com/questions/10343885/spring-3-1-cacheable-method-still-executed - ehcache configuration
