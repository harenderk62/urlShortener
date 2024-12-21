package com.harender.urlshortener.service;

import com.harender.urlshortener.model.UrlMapping;
import com.harender.urlshortener.repository.UrlMappingRepository;
import com.harender.urlshortener.service.engines.EngineFactory;
import com.harender.urlshortener.service.engines.EngineType;
import com.harender.urlshortener.service.engines.ShortUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlMappingRepository repository;

    @Autowired
    private Map<String, ShortUrlGenerator> generators;

    @Autowired
    private EngineFactory engineFactory;

    public String createShortUrl(String originalUrl,String alias, String engineType){
        String shortUrl;

        if(alias != null && !alias.isEmpty()){
            boolean isExist = repository.findByShortUrl(alias).isPresent();

            if(isExist){
                throw new IllegalArgumentException("This URL already taken");
            }

            shortUrl = alias;
        }else{
            try{
                EngineType type = EngineType.fromString(engineType);
                ShortUrlGenerator generator = engineFactory.getEngine(type);

                shortUrl = generator.generateShortUrl(originalUrl);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("No generator found for engine type: "+ engineType);

            }
        }

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortUrl(shortUrl);
        urlMapping.setCreatedAt(LocalDateTime.now());
        urlMapping.setExpiresAt(LocalDateTime.now().plusDays(2));
        repository.save(urlMapping);
        return shortUrl;
    }

    public String generateShortUrl(){
        return UUID.randomUUID().toString().substring(0,8);
    }

}
