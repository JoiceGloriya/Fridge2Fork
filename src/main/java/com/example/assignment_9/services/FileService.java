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

@Service
public class FileService {

	@Value("${file.name}")
	private String fileName;

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
