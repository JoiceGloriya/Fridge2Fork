package com.example.assignment_9.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
	
	@GetMapping("")
	public String getTest() {
		return "This is test endpoint";
	}
}
