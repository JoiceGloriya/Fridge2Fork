package com.example.WhizzRecipe.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.WhizzRecipe.dto.Recipe;

public class RecipeRepository {

	private Map<Long, Recipe> recipeData = new HashMap<>();

	public void save(Recipe recipe) {
		recipeData.put(recipe.getId(), recipe);
	}
}
