package com.harender.urlshortener.service.engines;

public enum EngineType {
    UUID("uuidEngine"),
    BASE64("base64Engine"),
    MD5("md5Engine");

    private final String beanName;


    EngineType(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName(){
        return beanName;
    }

    public static EngineType fromString(String value){
        for(EngineType engineType: values()){
            if(engineType.name().equalsIgnoreCase(value)){
                return engineType;
            }
        }
        throw new IllegalArgumentException("Invalid engine type: "+value);
    }
}
