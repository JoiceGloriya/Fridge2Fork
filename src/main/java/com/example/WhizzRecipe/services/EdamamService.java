package com.example.WhizzRecipe.services;

import com.example.WhizzRecipe.configuration.EdamamConfig;
import com.example.WhizzRecipe.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public List<Recipe> getAll(List<Recipe> allRecipes) {
        return allRecipes;
    }

    public List<Recipe> getVegan(List<Recipe> allRecipes) {
        return allRecipes.stream().filter(Recipe::getVegan).toList();
    }

    public List<Recipe> getGluten(List<Recipe> allRecipes) {
        return allRecipes.stream().filter(Recipe::getGlutenFree).toList();
    }

    public List<Recipe> getVegetarian(List<Recipe> allRecipes) {
        return allRecipes.stream().filter(Recipe::getVegetarian).toList();
    }

    public List<Recipe> getVeganGluten(List<Recipe> allRecipes) {
        return allRecipes.stream()
                .filter(recipe -> recipe.getGlutenFree() && recipe.getVegan())
                .toList();
    }

    public String getRecipes(String query) {
        edamamConfig.validateConfig();

        String url = String.format("%s?q=%s&app_id=%s&app_key=%s",
                edamamConfig.getBaseUrl(), query, edamamConfig.getAppId(), edamamConfig.getAppKey());

        logger.info("Requesting recipes from Edamam with URL: {}", url);

        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            logger.error("Error fetching recipes from Edamam: {}", e.getMessage());
            throw new RuntimeException("Error fetching recipes from Edamam: " + e.getMessage(), e);
        }
    }
}


