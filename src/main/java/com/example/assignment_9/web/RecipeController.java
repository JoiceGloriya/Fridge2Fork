package com.example.assignment_9.web;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_9.services.FileService;

@RestController
public class RecipeController {
	
	
	@Autowired
	private FileService fileService;

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
		try {
			List<CSVRecord> fileContent = fileService.processFile();
//			System.out.println(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
