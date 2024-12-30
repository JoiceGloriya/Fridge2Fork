package com.example.WhizzRecipe.controller;

import com.example.WhizzRecipe.services.EdamamService;
import com.example.WhizzRecipe.dto.Recipe;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/edamam")
public class EdamamController {

    private static final Logger logger = LoggerFactory.getLogger(EdamamController.class);

    private final EdamamService edamamService;

    @Autowired
    public EdamamController(EdamamService edamamService) {
        this.edamamService = edamamService;
    }

    @GetMapping("/searchByIngredients")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String ingredients) {
        logger.info("Ingredients received: {}", ingredients);

        String jsonResponse = edamamService.getRecipes(ingredients);

        logger.info("Response from Edamam API: {}", jsonResponse);

        List<Recipe> recipes = parseRecipes(jsonResponse);

        return ResponseEntity.ok(recipes);
    }

    private List<String> extractLabels(JsonNode labelsNode) {
        List<String> labels = new ArrayList<>();
        if (labelsNode.isArray()) {
            for (JsonNode label : labelsNode) {
                labels.add(label.asText());
            }
        }
        return labels;
    }


    private List<Recipe> parseRecipes(String jsonResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Recipe> recipes = new ArrayList<>();

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode hitsNode = rootNode.path("hits");

            for (JsonNode hit : hitsNode) {
                JsonNode recipeNode = hit.path("recipe");

                Recipe recipe = new Recipe();
                recipe.setTitle(recipeNode.path("label").asText());
                recipe.setVegan(recipeNode.path("vegan").asBoolean());
                recipe.setGlutenFree(recipeNode.path("glutenFree").asBoolean());
                recipe.setVegetarian(recipeNode.path("vegetarian").asBoolean());
                recipe.setDietLabels(extractLabels(recipeNode.path("dietLabels")));
                recipe.setHealthLabels(extractLabels(recipeNode.path("healthLabels")));
                recipe.setCautions(extractLabels(recipeNode.path("cautions")));
                recipe.setCalories(Math.round(recipeNode.path("calories").asDouble()));
                recipe.setTotalWeight(Math.round(recipeNode.path("totalWeight").asDouble()));
                recipe.setTotalTime(recipeNode.path("totalTime").asInt());
                recipe.setCuisineType(extractLabels(recipeNode.path("cuisineType")));
                recipe.setMealType(extractLabels(recipeNode.path("mealType")));
                recipe.setDishType(extractLabels(recipeNode.path("dishType")));
                recipes.add(recipe);
                recipe.setImageUrl(recipeNode.path("image").asText());

                List<String> ingredients = new ArrayList<>();
                JsonNode ingredientLines = recipeNode.path("ingredientLines");
                for (JsonNode ingredient : ingredientLines) {
                    ingredients.add(ingredient.asText());
                }
                recipe.setIngredients(ingredients);
                recipe.setImageUrl(recipeNode.path("image").asText());

            }
        } catch (Exception e) {
            logger.error("Error parsing Edamam response: {}", e.getMessage());
            e.printStackTrace();
        }

        return recipes;
    }
}

