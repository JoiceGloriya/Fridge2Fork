package com.example.WhizzRecipe.controller;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.example.assignment_9.dto.RecipeResponse;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WhizzRecipe.dto.Recipe;
import com.example.WhizzRecipe.services.FileService;
import com.example.WhizzRecipe.services.RecipeService;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RecipeController {

	private final FileService fileService;
	private final RecipeService recipeService;

	@Autowired
	public RecipeController(RecipeService recipeService, FileService fileService) {
		this.recipeService = recipeService;
		this.fileService = fileService;
	}

	@GetMapping("/search")
	public List<Recipe> searchRecipes(@RequestParam String query) {
		String jsonResponse = recipeService.getRecipes(query);
		// Parse JSON response into a list of Recipe objects
		return parseRecipes(jsonResponse);  // Implement this method to map JSON to Recipe objects
	}

	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree() {
		List<Recipe> recipes = fileService.loadData();
		if (recipes == null || recipes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No gluten-free recipes found.");
		}
		return recipeService.getGluten(recipes);
	}

	@GetMapping("/vegan")
	public List<Recipe> getVegan() {
		List<Recipe> recipes = fileService.loadData();
		if (recipes == null || recipes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No vegan recipes found.");
		}
		return recipeService.getVegan(recipes);
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGluten() {
		List<Recipe> recipes = fileService.loadData();
		if (recipes == null || recipes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No vegan and gluten-free recipes found.");
		}
		return recipeService.getVeganGluten(recipes);
	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian() {
		List<Recipe> recipes = fileService.loadData();
		if (recipes == null || recipes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No vegetarian recipes found.");
		}
		return recipeService.getVegetarian(recipes);
	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() {
		List<Recipe> recipes = fileService.loadData();
		if (recipes == null || recipes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No recipes found.");
		}
		return recipeService.getAll(recipes);
	}


	private List<Recipe> parseRecipes(String jsonResponse) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Recipe> recipes = new ArrayList<>();

		try {
			JsonNode rootNode = objectMapper.readTree(jsonResponse);
			JsonNode hitsNode = rootNode.path("hits");  // "hits" is the array of recipe results in the API response

			// Iterate through each hit and map it to a Recipe object
			for (JsonNode hit : hitsNode) {
				JsonNode recipeNode = hit.path("recipe");

				Recipe recipe = new Recipe();
				recipe.setTitle(recipeNode.path("label").asText());
				recipe.setVegan(recipeNode.path("vegan").asBoolean());
				recipe.setGlutenFree(recipeNode.path("glutenFree").asBoolean());
				recipe.setVegetarian(recipeNode.path("vegetarian").asBoolean());
				recipe.setImageUrl(recipeNode.path("image").asText());
				// Add other properties as needed based on the API response

				recipes.add(recipe);
			}
		} catch (Exception e) {
			e.printStackTrace(); // You can handle this more gracefully based on your needs
		}

		return recipes;
	}

}
