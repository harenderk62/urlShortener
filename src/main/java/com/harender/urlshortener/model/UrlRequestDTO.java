package com.harender.urlshortener.model;

public class UrlRequestDTO {
    private String originalUrl;
    private String alias;
    private String type;

    public void setOriginalUrl(String originalUrl){
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl(){
        return this.originalUrl;
    }

    public void setAlias(String alias){
        this.alias = alias;
    }

    public String getAlias(){
        return this.alias;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
