package com.example.WhizzRecipe.services;

//import java.io.IOException;
//import java.io.Reader;
//import java.util.ArrayList;
//import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVRecord;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
import com.example.WhizzRecipe.dto.Recipe;

@Service
public class FileService {

	@Value("${file.name}")
	private String fileName;

	// Process file using CommonCSV Dependency, then use results to create Recipe POGOs:
	public List<Recipe> loadData() {
		List<CSVRecord> data = processFile();
		return makeRecipeObjects(data);
	}

	private List<Recipe> makeRecipeObjects(List<CSVRecord> data) {
		// Create and collect Recipe Objects:
		List<Recipe> recipes = new ArrayList<>();
		for (CSVRecord record : data) {
			Recipe recipe = new Recipe();
			recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
			recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
			recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
			recipe.setInstructions(record.get("Instructions"));
			recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
			recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
			recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
			recipe.setServings(Integer.parseInt(record.get("Servings")));
			recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
			recipe.setTitle(record.get("Title"));
			recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
			recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));

			recipes.add(recipe);
		}
		return recipes;
	}

	public List<CSVRecord> processFile() {
		System.out.println("inside process file " + fileName);
		List<CSVRecord> fileContent = new ArrayList<>();
		try {
			// Using ClassPathResource to load the file from classpath
			ClassPathResource resource = new ClassPathResource(fileName);
			if (!resource.exists()) {
				System.err.println("File not found in classpath: " + fileName);
				return fileContent;  // Return empty list if file doesn't exist
			}

			Reader in = new InputStreamReader(resource.getInputStream());

			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free",
							"Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings",
							"Spoonacular Score", "Title", "Vegan", "Vegetarian")
					.withIgnoreSurroundingSpaces().withEscape('\\')
					.parse(in);

			Boolean lineOne = true;
			for (CSVRecord record : records) {
				if (lineOne) {
					lineOne = false;  // Skip header line
					continue;
				}
				fileContent.add(record);
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			// for handling exceptions, return an empty list
			return new ArrayList<>();
		}
		return fileContent;
	}
}
