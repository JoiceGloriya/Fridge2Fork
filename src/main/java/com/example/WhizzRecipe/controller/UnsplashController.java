package com.example.WhizzRecipe.controller;

import com.example.WhizzRecipe.services.UnsplashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsplashController {

    @Autowired
    private UnsplashService unsplashService;

    @GetMapping("/getRecipeImages")
    public String getRecipeImages(@RequestParam String query) {
        return unsplashService.getRecipeImages(query);
    }
}

