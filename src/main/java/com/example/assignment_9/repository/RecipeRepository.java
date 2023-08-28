package com.example.assignment_9.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.assignment_9.dto.Recipe;

public class RecipeRepository {
	private Map<Long, Recipe> recipeData = new HashMap<>();
	
	public void save(Recipe recipe) {
		recipeData.put(recipe.getId(), recipe);
	}
}
