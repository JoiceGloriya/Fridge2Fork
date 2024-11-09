package com.example.assignment_9.dto;

public class RecipeResponse {
    // Add fields based on the JSON structure of Edamam's response
    private Hits[] hits;

    // Getters and setters

    public static class Hits {
        private Recipe recipe;

        public Recipe getRecipe() {
            return recipe;
        }

        public void setRecipe(Recipe recipe) {
            this.recipe = recipe;
        }
    }

    public static class Recipe {
        private String label;
        private String image;
        private String url;

        // Getters and setters
    }

}

