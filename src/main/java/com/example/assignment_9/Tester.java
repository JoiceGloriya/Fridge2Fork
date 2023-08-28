package com.example.assignment_9;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class Tester {


	private static String fileName = "recipes.txt";

	
	public static void main(String[] args) throws IOException {
		processFile();
	}
	
	public static List<CSVRecord> processFile() throws IOException{
		// TODO Auto-generated method stub
        
		System.out.println("inside process file" + fileName);
		List<CSVRecord> fileContent = new ArrayList<>();
		Reader in = new FileReader(fileName);
		Iterable<CSVRecord> records = CSVFormat
				.DEFAULT
				.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian")
				.withIgnoreSurroundingSpaces()
				.withEscape('\\')
				.parse(in);
		Boolean lineOne = true;
		Integer counter = 0;
		for (CSVRecord record : records) {
			if (lineOne) {
				lineOne = false;
				continue;
			}

			counter++;
			fileContent.add(record);
			System.out.println(record.size());
		}

		System.out.println("counter is: " + counter);
		return fileContent;
	}

}
