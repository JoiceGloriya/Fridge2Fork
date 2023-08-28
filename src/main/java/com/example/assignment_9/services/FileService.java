package com.example.assignment_9.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class FileService {
	
	@Value("${file.name}")
	private String fileName;
	
	public List<String> processFile(){
		List<String> fileContent = new ArrayList<>();
		
		
		return fileContent;
	}
}
