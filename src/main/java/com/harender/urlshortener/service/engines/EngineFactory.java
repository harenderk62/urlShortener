package com.harender.urlshortener.service.engines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EngineFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public ShortUrlGenerator getEngine(EngineType type){
        return applicationContext.getBean(type.getBeanName(),ShortUrlGenerator.class);
    }
}
