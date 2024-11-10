package com.example.assignment_9.dto;


public class RecipeResponse {

    private Hits[] hits;  // Array of hits containing recipes

    // Getter and Setter for hits
    public Hits[] getHits() {
        return hits;
    }

    public void setHits(Hits[] hits) {
        this.hits = hits;
    }

    // Inner static class for Hit object
    public static class Hits {
        private Recipe recipe;  // Recipe object inside each hit

        // Getter and Setter for recipe
        public Recipe getRecipe() {
            return recipe;
        }

        public void setRecipe(Recipe recipe) {
            this.recipe = recipe;
        }
    }

    // Inner static class for Recipe object
    public static class Recipe {
        private String label;  // Recipe name
        private String image;  // Image URL of the recipe
        private String url;    // URL for the recipe (optional)

        // Getters and Setters for label, image, and url
        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}


