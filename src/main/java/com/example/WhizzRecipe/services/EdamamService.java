package com.example.WhizzRecipe.services;

import com.example.WhizzRecipe.configuration.EdamamConfig;
import com.example.WhizzRecipe.dto.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class EdamamService {

    private static final Logger logger = LoggerFactory.getLogger(EdamamService.class);

    private final EdamamConfig edamamConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public EdamamService(EdamamConfig edamamConfig, RestTemplate restTemplate) {
        this.edamamConfig = edamamConfig;
        this.restTemplate = restTemplate;
    }

    // Collect all recipes:
    public List<Recipe> getAll(List<Recipe> allRecipes) {
        return allRecipes;
    }

    // Filtering for vegan recipes:
    public List<Recipe> getVegan(List<Recipe> allRecipes) {
        return allRecipes.stream().filter(Recipe::getVegan).toList();
    }

    // Filter to collect gluten-free recipes:
    public List<Recipe> getGluten(List<Recipe> allRecipes) {
        return allRecipes.stream().filter(Recipe::getGlutenFree).toList();
    }

    // Filter to collect vegetarian recipes:
    public List<Recipe> getVegetarian(List<Recipe> allRecipes) {
        return allRecipes.stream().filter(Recipe::getVegetarian).toList();
    }

    // Filter to collect gluten-free AND vegan recipes:
    public List<Recipe> getVeganGluten(List<Recipe> allRecipes) {
        return allRecipes.stream()
                .filter(recipe -> recipe.getGlutenFree() && recipe.getVegan())
                .toList();
    }

    // Fetch recipes from Edamam API:
    public String getRecipes(String query) {
        String url = String.format("%s/v2?type=public&q=%s&app_id=%s&app_key=%s",
                edamamConfig.getBaseUrl(), query, edamamConfig.getAppId(), edamamConfig.getAppKey());

        logger.info("Requesting recipes from Edamam with URL: {}", url);

        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            logger.error("Error fetching recipes from Edamam: {}", e.getMessage());
            throw new RuntimeException("Error fetching recipes: " + e.getMessage(), e);
        }
    }
}


