package academy.learnprogramming.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



@Slf4j
public class WedAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_HOME = "dispatcher";
    @Override
    public void onStartup(ServletContext servletContext) {
        log.info("onStartup");

        // create the spring application context
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        //create the dispatcher servlet
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(context);

        // register and configure the dispatcher servlet
        ServletRegistration.Dynamic registration =
                servletContext.addServlet(DISPATCHER_SERVLET_HOME, dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }

}
