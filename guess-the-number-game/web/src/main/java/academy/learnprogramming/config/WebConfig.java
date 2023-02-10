package academy.learnprogramming.config;

import academy.learnprogramming.interceptor.RequestInterceptor;
import academy.learnprogramming.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // == constants ==
    // for Spanish, substitute Language, Country as es, ES
    // for English, substitute Language, Country as en, UK
    public static final String LANGUAGE = "en";
    public static final String COUNTRY = "UK";

    // == bean methods ==
    @Bean
    public LocaleResolver localeResolver(){
        return new SessionLocaleResolver();
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());

        //enable this if you want to use your own param, http://localhost:8080/?lang=es
//        LocaleChangeInterceptor localeChangeInterceptor =
//                new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        registry.addInterceptor(localeChangeInterceptor);

        // enable this to use default locale param in url http://localhost:8080/?locale=es
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

    // self created method (Not Tims) as the locale in properties files not working for me
    // Tim later created similar implementation in this class towards the end of the lecture
    // disabling mine to use Tims
//    @Bean
//    public FixedLocaleResolver localeResolver() {
//        //return new FixedLocaleResolver(new Locale("es", "ES"));
//        return new FixedLocaleResolver(new Locale(LANGUAGE, COUNTRY));
//
//    }



}
