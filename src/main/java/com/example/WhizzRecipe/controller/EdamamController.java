package com.example.WhizzRecipe.controller;

import com.example.WhizzRecipe.services.EdamamService;
import com.example.WhizzRecipe.dto.Recipe;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.conf.PropertyKey.logger;

@RestController
@RequestMapping("/api/edamam")
public class EdamamController {

    private static final Logger logger = LoggerFactory.getLogger(EdamamController.class);

    private final EdamamService edamamService;

    @Autowired
    public EdamamController(EdamamService edamamService) {
        this.edamamService = edamamService;
    }

    // Search recipes using the Edamam API
    @GetMapping("/searchByIngredients")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String ingredients) {
        // Log the incoming ingredients request
        logger.info("Ingredients received: {}", ingredients);

        // Get recipes from the Edamam API
        String jsonResponse = edamamService.getRecipes(ingredients);

        // Log the response from Edamam
        logger.info("Response from Edamam API: {}", jsonResponse);

        // Parse the JSON response to Recipe objects
        List<Recipe> recipes = parseRecipes(jsonResponse);

        // Return the list of recipes
        return ResponseEntity.ok(recipes);
    }

    // Method to extract labels from a JSON node (e.g., dietLabels, healthLabels, etc.)
    private List<String> extractLabels(JsonNode labelsNode) {
        List<String> labels = new ArrayList<>();
        if (labelsNode.isArray()) {
            for (JsonNode label : labelsNode) {
                labels.add(label.asText());
            }
        }
        return labels;
    }


    // Method to parse the JSON response from Edamam API
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

                // Extract and set the new properties
                recipe.setCalories(recipeNode.path("calories").asDouble());
                recipe.setTotalWeight(recipeNode.path("totalWeight").asDouble());
                recipe.setTotalTime(recipeNode.path("totalTime").asInt());
                recipe.setCuisineType(extractLabels(recipeNode.path("cuisineType")));
                recipe.setMealType(extractLabels(recipeNode.path("mealType")));
                recipe.setDishType(extractLabels(recipeNode.path("dishType")));
                recipes.add(recipe);

                // Extract ingredients
                List<String> ingredients = new ArrayList<>();
                JsonNode ingredientLines = recipeNode.path("ingredientLines");
                for (JsonNode ingredient : ingredientLines) {
                    ingredients.add(ingredient.asText());
                }
                recipe.setIngredients(ingredients);  // Set the ingredients list
                recipe.setImageUrl(recipeNode.path("image").asText());
                // Add the recipe to the list
                recipes.add(recipe);
            }
        } catch (Exception e) {
            logger.error("Error parsing Edamam response: {}", e.getMessage());
            e.printStackTrace();
        }

        return recipes;
    }
}

