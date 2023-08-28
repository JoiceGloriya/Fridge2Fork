package com.example.assignment_9.repository;

import java.util.HashMap;
import java.util.Map;

public class RecipeRepository {
	private Map<Long, Recipe> recipeData = new HashMap<>();
	
	public void save(Recipe recipe) {
		recipeData.put(recipe.getId(), recipe);
	}
}
