package com.harender.urlshortener.service.engines;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component("md5Engine")
public class HashingEngine implements ShortUrlGenerator {

    @Override
    public String generateShortUrl(String originalUrl) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] digest = md.digest(originalUrl.getBytes());

            BigInteger no = new BigInteger(1, digest);
            String hashText = no.toString(16);

            return hashText.substring(0,8);
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException("Error generating MD5 hash",e);
        }
    }

}
