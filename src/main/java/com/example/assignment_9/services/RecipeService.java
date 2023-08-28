package com.example.assignment_9.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assignment_9.dto.Recipe;

@Service
public class RecipeService {
	public List<Recipe> getAll(List<Recipe> allRecipes) {
		return allRecipes;
	}
	public List<Recipe> getVegan(List<Recipe> allRecipes) {
		List<Recipe> veganRecipes = new ArrayList<>();
		veganRecipes = allRecipes.stream().filter(item -> item.getVegan()).toList();
		
		return veganRecipes;
	}
	public List<Recipe> getGluten(List<Recipe> allRecipes) {
		List<Recipe> getGlutenFree = new ArrayList<>();
		getGlutenFree = allRecipes.stream().filter(item -> item.getGlutenFree()).toList();

		return getGlutenFree;
	}

	public List<Recipe> getVegetarian(List<Recipe> allRecipes) {
		List<Recipe> vegeRecipes = new ArrayList<>();
		vegeRecipes = allRecipes.stream().filter(item -> item.getVegetarian()).toList();

		return vegeRecipes;
	}

	public List<Recipe> getVeganGluten(List<Recipe> allRecipes) {
		List<Recipe> getVeganGlutenRecipes = new ArrayList<>();
		getVeganGlutenRecipes = allRecipes.stream().filter(item -> ((item.getGlutenFree() && item.getVegan()))).toList();

		return getVeganGlutenRecipes;
	}


}
