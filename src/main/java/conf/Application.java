package conf;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import service.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("service")
public class Application {

    @Bean
    LocalizationResources localizationResources(LocalizationAspect localizationAspect){
        AspectJProxyFactory factory = new AspectJProxyFactory(new EmptyImpl());

        factory.addInterface(LocalizationResources.class);
        factory.addAspect(localizationAspect);

        return factory.getProxy();
    }

    @Bean
    MessageSource localizationMessageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();

        source.setCacheSeconds(15);
        source.setDefaultEncoding("UTF-8");
        source.setBasename("message");

        return source;
    }

//    @Bean
//    LocalizationAspect localizationAspect(SessionService sessionService){
//        return new LocalizationAspect(localizationMessageSource(), sessionService);
//    }
}
