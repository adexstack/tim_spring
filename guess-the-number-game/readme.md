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