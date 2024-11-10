package com.example.WhizzRecipe.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

@Component
public class DatabaseConnection {

    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        try {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS recipes (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "Title VARCHAR(255) NOT NULL," +
                    "CookingMinutes INT," +
                    "DairyFree BOOLEAN," +
                    "GlutenFree BOOLEAN," +
                    "Instructions TEXT," +
                    "PreparationMinutes INT," +
                    "PricePerServing DECIMAL(10,2)," +
                    "ReadyInMinutes INT," +
                    "Servings INT," +
                    "SpoonacularScore DECIMAL(5,2)," +
                    "Vegan BOOLEAN," +
                    "Vegetarian BOOLEAN)";

            jdbcTemplate.execute(createTableQuery);
            logger.info("Table created successfully or already exists.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating table: " + e.getMessage(), e);
        }

        List<Recipe> recipes = Arrays.asList(
                new Recipe("Roasted Salmon With Lime And Cilantro", 10, true, true,
                        "Preheat oven to 450 degrees. Arrange salmon in a shallow baking pan. Season with salt and pepper. Roast until no longer pink in the middle and flaky, 10 to 13 minutes. Using a flat spatula, remove fillets, leaving skin on the baking sheet.",
                        5, new BigDecimal("427.92"), 15, 4, new BigDecimal("99.0"), false, false),
                new Recipe("Spaghetti with Marinara Sauce", 20, true, true,
                        "Cook pasta according to package instructions. In a separate pan, heat marinara sauce. Combine and serve.",
                        10, new BigDecimal("2.50"), 30, 2, new BigDecimal("75.0"), false, true)
                // Add more recipes as needed
        );

        String insertQuery = "INSERT INTO recipes (Title, CookingMinutes, DairyFree, GlutenFree, Instructions, PreparationMinutes, PricePerServing, ReadyInMinutes, Servings, SpoonacularScore, Vegan, Vegetarian) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        for (Recipe recipe : recipes) {
            try {
                jdbcTemplate.update(insertQuery, recipe.getTitle(), recipe.getCookingMinutes(), recipe.isDairyFree(),
                        recipe.isGlutenFree(), recipe.getInstructions(), recipe.getPreparationMinutes(),
                        recipe.getPricePerServing(), recipe.getReadyInMinutes(), recipe.getServings(),
                        recipe.getSpoonacularScore(), recipe.isVegan(), recipe.isVegetarian());
                logger.info("Recipe inserted successfully: " + recipe.getTitle());
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error inserting recipe: " + recipe.getTitle() + " - " + e.getMessage(), e);
            }
        }
    }

    // A helper class to represent a Recipe object
    public static class Recipe {
        private String title;
        private int cookingMinutes;
        private boolean dairyFree;
        private boolean glutenFree;
        private String instructions;
        private int preparationMinutes;
        private BigDecimal pricePerServing;
        private int readyInMinutes;
        private int servings;
        private BigDecimal spoonacularScore;
        private boolean vegan;
        private boolean vegetarian;

        // Constructor, getters, and setters

        public Recipe(String title, int cookingMinutes, boolean dairyFree, boolean glutenFree,
                      String instructions, int preparationMinutes, BigDecimal pricePerServing,
                      int readyInMinutes, int servings, BigDecimal spoonacularScore,
                      boolean vegan, boolean vegetarian) {
            this.title = title;
            this.cookingMinutes = cookingMinutes;
            this.dairyFree = dairyFree;
            this.glutenFree = glutenFree;
            this.instructions = instructions;
            this.preparationMinutes = preparationMinutes;
            this.pricePerServing = pricePerServing;
            this.readyInMinutes = readyInMinutes;
            this.servings = servings;
            this.spoonacularScore = spoonacularScore;
            this.vegan = vegan;
            this.vegetarian = vegetarian;
        }

        // Getters only for brevity
        public String getTitle() {
            return title;
        }

        public int getCookingMinutes() {
            return cookingMinutes;
        }

        public boolean isDairyFree() {
            return dairyFree;
        }

        public boolean isGlutenFree() {
            return glutenFree;
        }

        public String getInstructions() {
            return instructions;
        }

        public int getPreparationMinutes() {
            return preparationMinutes;
        }

        public BigDecimal getPricePerServing() {
            return pricePerServing;
        }

        public int getReadyInMinutes() {
            return readyInMinutes;
        }

        public int getServings() {
            return servings;
        }

        public BigDecimal getSpoonacularScore() {
            return spoonacularScore;
        }

        public boolean isVegan() {
            return vegan;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }
    }
}





