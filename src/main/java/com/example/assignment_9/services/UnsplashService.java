package com.example.assignment_9.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UnsplashService {

    private static final String UNSPLASH_API_URL = "https://api.unsplash.com/search/photos?query={query}&client_id={client_id}";

    // Inject the Unsplash API key from application.properties
    @Value("${unsplash.api.key}")
    private String apiKey;

    public String getRecipeImages(String query) {
        // Initialize RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Prepare the URL with the query and API key
        String url = UNSPLASH_API_URL;

        try {
            // Make a GET request to the Unsplash API with query and API key
            UnsplashResponse response = restTemplate.getForObject(url, UnsplashResponse.class, query, apiKey);

            // Check if results exist, and return the image URL (or empty if not)
            if (response != null && !response.getResults().isEmpty()) {
                return response.getResults().get(0).getUrls().getRegular(); // Return the first image URL
            }
        } catch (HttpClientErrorException e) {
            // Log the error in case of HTTP issues
            System.out.println("Error occurred while fetching data from Unsplash: " + e.getMessage());
        } catch (Exception e) {
            // Catch other exceptions like network issues
            System.out.println("Unexpected error: " + e.getMessage());
        }

        return ""; // Return an empty string if no image is found or an error occurred
    }
}


