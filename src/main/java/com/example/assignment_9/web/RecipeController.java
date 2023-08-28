package com.example.assignment_9.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_9.dto.Recipe;
import com.example.assignment_9.services.FileService;
import com.example.assignment_9.services.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	private FileService fileService;

	@Autowired
	private RecipeService recipeService;

	@GetMapping("")
	public String getTest() {
		return "This is test endpoint";
	}

	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree() {
		List<Recipe> recipes = recipeService.getGluten(fileService.loadData());
		return recipes;
	}

	@GetMapping("/vegan")
	public List<Recipe> getVegan() {
		List<Recipe> recipes = recipeService.getVegan(fileService.loadData());
		return recipes;
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGluten() {
		List<Recipe> recipes = recipeService.getVeganGluten(fileService.loadData());
		return recipes;
	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVege() {
		List<Recipe> recipes = recipeService.getVegan(fileService.loadData());
		return recipes;
	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() {
		List<Recipe> recipes = recipeService.getAll(fileService.loadData());
		return recipes;
	}
}
