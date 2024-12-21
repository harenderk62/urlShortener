package com.harender.urlshortener.service.engines;

import org.springframework.stereotype.Component;

@Component("base64Engine")
public class Base64Engine implements ShortUrlGenerator {

    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static long counter = 1;
    private static final int SHORT_URL_LENGTH = 8;

    @Override
    public synchronized String generateShortUrl(String originalUrl) {
        long id = counter++;
        StringBuilder shortUrl = new StringBuilder();

        while (id > 0) {
            shortUrl.append(BASE62.charAt((int) (id % 62)));
            id /= 62;
        }

        shortUrl.reverse();

        while (shortUrl.length() < SHORT_URL_LENGTH) {
            shortUrl.append(BASE62.charAt((int) (Math.random() * 62)));
        }

        return shortUrl.toString();
    }
}
