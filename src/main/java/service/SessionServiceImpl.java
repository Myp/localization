package service;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class SessionServiceImpl implements SessionService {


    @Override
    public Locale currentLocale() {
//        return Locale.forLanguageTag("ru-RU");
        return Locale.US;
    }
}
