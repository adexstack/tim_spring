package academy.learnprogramming.config;

import academy.learnprogramming.interceptor.RequestInterceptor;
import academy.learnprogramming.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // == constants ==
    // for Spanish, substitute Language, Country as es, ES
    // for English, substitute Language, Country as en, UK
    public static final String LANGUAGE = "en";
    public static final String COUNTRY = "UK";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());
    }

    @Bean
    public FixedLocaleResolver localeResolver() {
        //return new FixedLocaleResolver(new Locale("es", "ES"));
        return new FixedLocaleResolver(new Locale(LANGUAGE, COUNTRY));

    }

}
