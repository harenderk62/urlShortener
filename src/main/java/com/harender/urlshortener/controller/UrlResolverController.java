package com.harender.urlshortener.controller;

import com.harender.urlshortener.service.UrlResolverService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/{shortUrl}")
public class UrlResolverController {

    @Autowired
    private UrlResolverService service;

    @GetMapping
    public void shortUrlResolver(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        String originalUrl = service.resolveShortUrl(shortUrl);
        response.sendRedirect(originalUrl);
    }
}
