package com.example.WhizzRecipe.controller;

import com.example.WhizzRecipe.services.EdamamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final EdamamService edamamService;

    @Autowired
    public HomeController(EdamamService edamamService) {
        this.edamamService = edamamService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/searchByIngredients")
    public String searchRecipesByIngredients(@RequestParam String ingredients, Model model) {

        String edamamRecipes = edamamService.getRecipes(ingredients);

        model.addAttribute("edamamRecipes", edamamRecipes);

        return "searchResults";
    }
}

