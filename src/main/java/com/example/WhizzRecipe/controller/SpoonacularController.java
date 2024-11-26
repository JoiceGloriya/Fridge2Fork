package com.example.WhizzRecipe.controller;

import com.example.WhizzRecipe.services.SpoonacularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SpoonacularController {
    private final SpoonacularService spoonacularService;

    @Autowired
    public SpoonacularController(SpoonacularService spoonacularService) {
        this.spoonacularService = spoonacularService;
    }

    @GetMapping("/recipes")
    public Map<String, Object> getRecipesByIngredients(@RequestParam String ingredients) {
        return spoonacularService.findRecipesByIngredients(ingredients);
    }
}

