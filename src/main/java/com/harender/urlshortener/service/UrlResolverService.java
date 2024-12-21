package com.harender.urlshortener.service;

import com.harender.urlshortener.model.UrlMapping;
import com.harender.urlshortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlResolverService {

    @Autowired
    private UrlMappingRepository repository;

    public String resolveShortUrl(String shortUrl){
        UrlMapping urlMapping = repository.findByShortUrl(shortUrl).orElseThrow(()-> new RuntimeException("URL not found"));
        return urlMapping.getOriginalUrl();
    }
}
