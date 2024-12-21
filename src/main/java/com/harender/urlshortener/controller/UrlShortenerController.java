package com.harender.urlshortener.controller;

import com.harender.urlshortener.model.UrlRequestDTO;
import com.harender.urlshortener.model.UrlResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.harender.urlshortener.service.UrlShortenerService;

@RestController
@RequestMapping("/api/shorten")
public class UrlShortenerController  {

    @Autowired
    private UrlShortenerService service;

    @PostMapping
    public ResponseEntity<UrlResponseDTO> getShortUrl(@RequestBody UrlRequestDTO urlRequestDTO, HttpServletRequest request){
        String originalUrl = urlRequestDTO.getOriginalUrl();
        String alias = urlRequestDTO.getAlias();
        String type = urlRequestDTO.getType();

        if(originalUrl.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UrlResponseDTO("URL is required", 400));
        }

        try{
            String shortUrl = service.createShortUrl(originalUrl,alias,type);
            String baseUrl = getBaseUrl(request);

            String fullShortUrl = baseUrl + "/" + shortUrl;
            int responseCode = 200;
            return ResponseEntity.ok(new UrlResponseDTO(fullShortUrl,responseCode));
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new UrlResponseDTO(e.getMessage(),400));
        }
    }

    private String getBaseUrl(HttpServletRequest request){
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }

}
