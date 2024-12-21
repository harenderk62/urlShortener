package com.harender.urlshortener.service.engines;

public interface ShortUrlGenerator {
    String generateShortUrl(String originalUrl);
}
