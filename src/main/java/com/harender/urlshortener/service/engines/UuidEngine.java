package com.harender.urlshortener.service.engines;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("uuidEngine")
public class UuidEngine implements ShortUrlGenerator {

    @Override
    public String generateShortUrl(String originalUrl){
        return UUID.randomUUID().toString().substring(0,8);
    }
}
