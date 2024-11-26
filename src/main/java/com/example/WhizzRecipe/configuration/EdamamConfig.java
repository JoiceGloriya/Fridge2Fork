package com.example.WhizzRecipe.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdamamConfig {

    // Properties read from application.properties or environment variables
    @Value("${edamam.api.url:#{null}}") // Default to null if not provided
    private String baseUrl;

    @Value("${edamam.api.id:#{null}}") // Default to null if not provided
    private String appId;

    @Value("${edamam.api.key:#{null}}") // Default to null if not provided
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

