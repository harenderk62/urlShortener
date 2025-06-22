package com.harender.urlshortener.controller;

import com.harender.urlshortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsRestController {

    @Autowired
    private UrlMappingRepository repository;

    @GetMapping("/api/analytics")
    public Object getAnalytics() {
        return repository.findAll();
    }
}
