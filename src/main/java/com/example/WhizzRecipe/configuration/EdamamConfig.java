package com.example.WhizzRecipe.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdamamConfig {

    @Value("${edamam.api.url:#{null}}")
    private String baseUrl;

    @Value("${edamam.api.id:#{null}}")
    private String appId;

    @Value("${edamam.api.key:#{null}}") 
    private String appKey;

    // Getter methods
    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppKey() {
        return appKey;
    }


    public void validateConfig() {
        if (baseUrl == null || appId == null || appKey == null) {
            throw new IllegalArgumentException("Edamam API configuration is incomplete.");
        }
    }
}

