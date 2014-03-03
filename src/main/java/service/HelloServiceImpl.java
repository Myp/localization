package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    LocalizationResources localizationResources;

    @Override
    public String sayGreeting() {
        return localizationResources.sayHello();
    }

    @Override
    public String sayHi(String name) {
        return localizationResources.sayHi(name);
    }


}
