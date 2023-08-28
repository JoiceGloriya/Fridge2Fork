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
	public String getGlutenFree() {
		return "This is gluten-free\" endpoint";
	}

	@GetMapping("/vegan")
	public List<Recipe> getVegan() {
		List<Recipe> veganRecipes = recipeService.getVegan(fileService.loadData());
//			System.out.println(fileContent);
		return veganRecipes;
	}

	@GetMapping("/vegan-and-gluten-free")
	public String getVeganAndGluten() {
		return "This is vegan-and-gluten-free endpoint";
	}

	@GetMapping("/vegetarian")
	public String getVege() {
		return "This is vegetarian endpoint";
	}

	@GetMapping("/all-recipes")
	public String allRecipes() {
		return "This is all-recipes endpoint";
	}
}
