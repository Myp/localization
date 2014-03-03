package service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LocalizationAspect {

    @Autowired
    MessageSource localizationMessageSource;

    @Autowired
    SessionService sessionService;

    @Pointcut("execution(* LocalizationResources.*(..))")
    public void localizationResourceMethod(){}

    @Around("localizationResourceMethod()")
    public String localize(ProceedingJoinPoint pjp){

        String code = pjp.getSignature().getName();

        try {
           return localizationMessageSource.getMessage(code, pjp.getArgs(), sessionService.currentLocale());
        } catch (NoSuchMessageException ex) {
           throw new RuntimeException("not found key with name " + code);
        }
    }
}
