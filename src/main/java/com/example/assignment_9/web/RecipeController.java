package com.example.assignment_9.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

	@GetMapping("")
	public String getTest() {
		return "This is test endpoint";
	}

	@GetMapping("/gluten-free")
	public String getGlutenFree() {
		return "This is gluten-free\" endpoint";
	}

	@GetMapping("/vegan")
	public String getVegan() {
		return "This is vegan endpoint";
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
