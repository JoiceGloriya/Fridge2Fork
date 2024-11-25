package com.example.WhizzRecipe.dto;


public class RecipeResponse {

    private Hits[] hits;  // Array of hits containing recipes

    public Hits[] getHits() {
        return hits;
    }

    public void setHits(Hits[] hits) {
        this.hits = hits;
    }

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

    public static class Recipe {
        private String label;  // Recipe name
        private String image;  // Image URL of the recipe
        private String url;    // URL for the recipe (optional)

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


