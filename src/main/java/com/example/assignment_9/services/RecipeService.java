package com.example.assignment_9.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assignment_9.dto.Recipe;

@Service
public class RecipeService {
	public List<Recipe> getVegan(List<Recipe> allRecipes) {
		List<Recipe> veganRecipes = new ArrayList<>();
		veganRecipes = allRecipes.stream()
								 .filter(item->item.getVegan())
								 .toList();
		
		
		return veganRecipes;
	}
}
