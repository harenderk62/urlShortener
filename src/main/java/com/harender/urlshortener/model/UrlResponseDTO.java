package com.harender.urlshortener.model;

public class UrlResponseDTO {
    private String fullShortUrl;
    private int responseCode;

    public UrlResponseDTO(String fullShortUrl,int responseCode){
        this.fullShortUrl = fullShortUrl;
        this.responseCode = responseCode;
    }

    public String getFullShortUrl(){
        return this.fullShortUrl;
    }

    public void setFullShortUrl(String fullShortUrl){
        this.fullShortUrl = fullShortUrl;
    }

    public int getResponseCode(){
        return this.responseCode;
    }

    public void setResponseCode(int responseCode){
        this.responseCode = responseCode;
    }
}
