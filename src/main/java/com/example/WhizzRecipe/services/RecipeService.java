package com.example.WhizzRecipe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.WhizzRecipe.dto.Recipe;

@Service
public class RecipeService {


    @Value("${edamam.api.key}")
    private String apiKey;

    @Value("${edamam.api.id}")
    private String apiId;

    private final RestTemplate restTemplate;

    public RecipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // Collect all recipes:
    public List<Recipe> getAll(List<Recipe> allRecipes) {
        return allRecipes;
    }

    // Filter to collect vegan recipes:
    public List<Recipe> getVegan(List<Recipe> allRecipes) {
        List<Recipe> veganRecipes = new ArrayList<>();
        veganRecipes = allRecipes.stream().filter(item -> item.getVegan()).toList();

        return veganRecipes;
    }

    // Filter to collect gluten-free recipes:
    public List<Recipe> getGluten(List<Recipe> allRecipes) {
        List<Recipe> getGlutenFree = new ArrayList<>();
        getGlutenFree = allRecipes.stream().filter(item -> item.getGlutenFree()).toList();

        return getGlutenFree;
    }

    // Filter to collect vegetarian recipes:
    public List<Recipe> getVegetarian(List<Recipe> allRecipes) {
        List<Recipe> vegeRecipes = new ArrayList<>();
        vegeRecipes = allRecipes.stream().filter(item -> item.getVegetarian()).toList();

        return vegeRecipes;
    }

    // Filter to collect gluten free AND vegetarian recipes:
    public List<Recipe> getVeganGluten(List<Recipe> allRecipes) {
        List<Recipe> getVeganGlutenRecipes = new ArrayList<>();
        getVeganGlutenRecipes = allRecipes.stream().filter(item -> ((item.getGlutenFree() && item.getVegan()))).toList();

        return getVeganGlutenRecipes;
    }

    public String getRecipes(String query) {
        // Edamam API URL for recipe search
        String url = String.format("https://api.edamam.com/api/recipes/v2?type=public&q=%s&app_id=%s&app_key=%s",
                query, apiId, apiKey);

        // Make the HTTP request to the API
        return restTemplate.getForObject(url, String.class);
    }
}

