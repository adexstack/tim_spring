Tim used Java 10, I use Java 17

This project is implemented with java 17 and spring boot 2.7.8 and run successfully.
It was completed in spring section (exclusive of spring boot)
This project is later re-used in "Spring boot" section and reconfigured (majorly all the POMs, added properties file, moved Main class to package level with some content tweaks
, changed and edit the content of -> logback to logback-spring.xml )
Ensure you change project all modules, sdks, languages to 11 in Settings 

Note that Tomacat only started when the Main class in web module is run (not in console module)
because only the web module has the Spring MVC (Which has Tomcat).
Note that the web and console module are independent of each other (doesn't know about each other
) they only share the core module.

Added spring-boot-devtools dependency to POM
scope is "runtime" in order to ensure accidental dependency and only use this at runtime in transitive

I had to change the following th in templates to the below(bad hardcoded routes) cz not working for me 
<a th:href="@{__${RESTART}__}"> 
<a th:href="@{__${HOME}__}"> 
<a th:href="@{__${PLAY}__}">

hardcoded with this
---------------------
{/restart}
{/}
{/play}

Added fragments (reusable template) for header and footer. Using the footer template in previews only.

Version 2.0.3 doesn't support Decoupled Logic out of the box, hence created DecoupledLogicSetup.java
Implemented Template logic decoupling to isolate normal HTML file from Thymeleaf file
Set thymeleaf logging in logback-spring.xml
Internationlization (i18n) to allow application easily adapted to various languages

Tim's key value for locale (for internationalization) in application.properties doesn't work for my Spring Boot 2.7.8 version
Workaround using:
https://www.udemy.com/course/java-spring-framework-masterclass/learn/lecture/11095626#questions/6580776
Added: public FixedLocaleResolver localeResolver() in WebConfig class

Request Interception: useful for cross-cutting concerns to avoid repetitive handler code like: checking user permission, checking security, 
changing globally used params in Spring model
