package com.example.WhizzRecipe.controller;

import com.example.WhizzRecipe.services.EdamamService;
import com.example.WhizzRecipe.dto.Recipe;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/edamam")
public class EdamamController {

    private final EdamamService edamamService;

    @Autowired
    public EdamamController(EdamamService edamamService) {
        this.edamamService = edamamService;
    }

    // Search recipes using the Edamam API
    @GetMapping("/search")
    public List<Recipe> searchRecipes(@RequestParam String query) {
        String jsonResponse = edamamService.getRecipes(query);  // Assuming the service fetches the data from Edamam
        return parseRecipes(jsonResponse);  // Parse the response and map it to Recipe objects
    }

    private List<Recipe> parseRecipes(String jsonResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Recipe> recipes = new ArrayList<>();

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode hitsNode = rootNode.path("hits");

            // Map each hit to a Recipe object
            for (JsonNode hit : hitsNode) {
                JsonNode recipeNode = hit.path("recipe");

                Recipe recipe = new Recipe();
                recipe.setTitle(recipeNode.path("label").asText());
                recipe.setVegan(recipeNode.path("vegan").asBoolean());
                recipe.setGlutenFree(recipeNode.path("glutenFree").asBoolean());
                recipe.setVegetarian(recipeNode.path("vegetarian").asBoolean());
                recipes.add(recipe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return recipes;
    }
}

