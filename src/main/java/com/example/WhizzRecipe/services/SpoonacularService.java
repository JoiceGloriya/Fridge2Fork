package com.example.WhizzRecipe.services;

import com.example.WhizzRecipe.configuration.SpoonacularConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Service
public class SpoonacularService {

    private static final Logger logger = LoggerFactory.getLogger(SpoonacularService.class);

    private final SpoonacularConfig spoonacularConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public SpoonacularService(SpoonacularConfig spoonacularConfig) {
        this.spoonacularConfig = spoonacularConfig;
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Object> findRecipesByIngredients(String ingredients) {
        String url = String.format("%s/recipes/findByIngredients?ingredients=%s&apiKey=%s",
                spoonacularConfig.getBaseUrl(),
                ingredients,
                spoonacularConfig.getKey());

        logger.info("Requesting recipes from Spoonacular with URL: {}", url); // Log the request

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                logger.info("Successfully fetched recipes from Spoonacular.");
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(response.getBody(), Map.class); // Parse JSON manually
            } else {
                logger.error("Received non-success status code: {}", response.getStatusCode());
                throw new RuntimeException("Failed to fetch recipes: " + response.getStatusCode());
            }
        } catch (Exception e) {
            logger.error("Error occurred while fetching recipes: {}", e.getMessage());
            throw new RuntimeException("Error fetching recipes from Spoonacular: " + e.getMessage(), e);
        }
    }
}
