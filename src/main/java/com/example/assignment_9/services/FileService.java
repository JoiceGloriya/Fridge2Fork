package com.example.assignment_9.services;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.assignment_9.dto.Recipe;

@Service
public class FileService {

	@Value("${file.name}")
	private String fileName;

	public List<Recipe> loadData(){
		List<CSVRecord> data = null;
		try {
			data = processFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return makeRecipeObjects(data);
	}

	private List<Recipe> makeRecipeObjects(List<CSVRecord> data) {
		// TODO Auto-generated method stub
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

	public List<CSVRecord> processFile() throws IOException {
		// TODO Auto-generated method stub

		System.out.println("inside process file " + fileName);
		List<CSVRecord> fileContent = new ArrayList<>();
//		Reader in = new FileReader("recipes.txt");
		Reader in = new FileReader(fileName);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free",
				"Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings",
				"Spoonacular Score", "Title", "Vegan", "Vegetarian").withIgnoreSurroundingSpaces().withEscape('\\')
				.parse(in);
		Boolean lineOne = true;
//		Integer counter = 0;
		for (CSVRecord record : records) {
			if (lineOne) {
				lineOne = false;
				continue;
			}
//			counter++;
			fileContent.add(record);
		}

		return fileContent;
	}

}
