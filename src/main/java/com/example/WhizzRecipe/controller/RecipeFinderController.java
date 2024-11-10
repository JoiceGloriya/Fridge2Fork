//package com.example.assignment_9.controller;
//
//import com.example.assignment_9.dto.Recipe;
//import com.example.assignment_9.services.RecipeService;
//import com.example.assignment_9.services.UnsplashService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import java.util.List;
//
//@RestController
//public class RecipeFinderController {
//
//    @Autowired
//    private RecipeService recipeService;  // Service to get recipes
//
//    @Autowired
//    private UnsplashService unsplashService; // Service to get images
//
//    @GetMapping("/findRecipes")
//    public ModelAndView findRecipes(@RequestParam String ingredients, @RequestParam String preferences) {
//        // Get recipes based on ingredients and preferences
//        List<Recipe> recipes = recipeService.getRecipes();
//
//        // Fetch relevant images for each recipe
//        for (Recipe recipe : recipes) {
//            String query = recipe.getTitle();
//            String imageUrl = unsplashService.getRecipeImages(query);
//            recipe.setImageUrl(imageUrl); // Set the image URL
//        }
//
//        // Send the recipes, images, and dietary preferences to the frontend
//        ModelAndView modelAndView = new ModelAndView("recipeResults");
//        modelAndView.addObject("recipes", recipes);  // This will include the title, image, and dietary info for each recipe
//        modelAndView.addObject("preferences", preferences); // Pass dietary preferences to the view
//        return modelAndView;
//    }
//}
//
//
