package com.example.WhizzRecipe.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpoonacularConfig {

    // Properties read from application.properties or environment variables
    @Value("${spoonacular.api.url:#{null}}")  // Default to null if not provided
    private String baseUrl;

    @Value("${spoonacular.api.key:#{null}}")  // Default to null if not provided
    private String key;

    // Getter methods
    public String getBaseUrl() {
        return baseUrl;
    }

    public String getKey() {
        return key;
    }

    public void validateConfig() {
        if (baseUrl == null || key == null) {
            throw new IllegalArgumentException("Spoonacular API configuration is incomplete.");
        }
    }
}

