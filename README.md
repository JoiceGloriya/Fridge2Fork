# WhizzRecipe - Dietary Recipe Finder

WhizzRecipe is a web application that allows users to find recipes based on available ingredients and dietary preferences. It uses numerous APIs to retrieve recipe specifics, images, and nutritional data. The app allows users to search for ingredients, get recipe recommendations, and browse related images, making it easier to plan meals based on what they have in the kitchen.

## Features:
- Recipe Search by ingredients: Users can search for recipes depending on the ingredients they have.
- Dietary Preference Filters: Supports dietary choices such as vegan, gluten-free, vegetarian, and more.
- Nutritional Information: Provides detailed nutritional information on dishes, such as calories, fat, protein, and carbs.
- Recipe photographs: Retrieves recipe images from both Edamam and Spoonacular APIs, but for higher-quality and more visually appealing images, the Unsplash API is used to provide images for a visual preview.
- Multiple Recipe APIs: Combines Edamam, Spoonacular, and Unsplash APIs to improve search results.

## APIs used:

### Edamam's API:

Example request:
```bash
https://api.edamam.com/search?q=chicken,tomato&app_id=yourAppId&app_key=yourAppKey
```
Returns a collection of recipes featuring ingredients, instructions,
nutritional info, and more.

### Spoonacular's API:

Searches for recipes using certain components and returns recipe titles,
ingredients, photos, and missing ingredients. 

Example request:
```bash
https://api.spoonacular.com/recipes/findByIngredients?components=tomato,cheese&apiKey=yourApiKey
```
Returns recipe suggestions with details on used and missing ingredients.

### Unsplash's API:

Recipe visuals (apart from the images that were generated by Edamam as
well as Spoonacular) were generated based on a keyword query.

Example Request:
```bash
https://localhost:8080/getRecipeImages?query=pizza
```
Returns an URL of a picture for a recipe based on the search query.

## Setup and Installation Requirements:

- Java 11 or above. 
- Spring Boot 2.x or higher
- Maven IntelliJ IDEA (or other Java IDE) 
- Access the APIs (Edamam, Spoonacular, Unsplash)

## Cloning:

Clone the repo with bash.
Copy the code below:
```bash
git clone
https://github.com/JoiceGloriya/WhizzRecipe.git
cd WhizzRecipe
```

## Environmental Variables:

Set up the following environment variables in your application.properties or application.yml:

### Edamam\'s API:

Copy the code below:
```bash
edamam.api.url=https://api.edamam.com
edamam.api.id=yourAppId edamam.api.key=yourAppKey
```

### Spoonacular API:

Copy the code below:
```bash
spoonacular.api.url=https://api.spoonacular.com/recipes
spoonacular.api.key=yourApiKey
```

### Unsplash API:

Copy the code below:
```bash
unsplash.api.url = https://api.unsplash.com/photos unsplash.api.key=yourApiKey
```

Run the Spring Boot application with the following:

Maven command: 
```bash
mvn spring-boot:run
```

Alternatively, use can your IDE\'s run configuration.

## Accessing Endpoints: 

### Edamam API for Recipe Search:

Enter:
```bash
https://api.edamam.com/search?q=chicken,tomato&app_id=yourAppId&app_key=yourAppKey
```
Sample Output:
A JSON response containing recipe info such as ingredients, nutritional values, recipe photos, and more.

### Recipes searching (using recipe.txt):

Enter:
```bash
http://localhost:8080/vegan-and-gluten-free
```
Sample Output:
Recipe specifics for vegan and gluten-free meals, including instructions, portion sizes, and nutritional information.

### Spoonacular API (Recipes by Ingredient):

Enter: 
```bash
https://api.spoonacular.com/recipes/findByIngredients?ingredients=tomato,cheese&apiKey=yourApiKey
```
Sample Output: A list of recipes, including used ingredients, missing
ingredients, and recipe descriptions.

### Unsplash\'s API (Get Recipe Image):

Enter: 
```bash
http://localhost:8080/getRecipeImages?query=pizza
```
Sample Output:
An image URL for the recipe based on the query. Contributing If you\'d like to contribute to the development of WhizzRecipe, feel free to fork the repository and submit a pull request with your improvements or fixes.

### Steps for Contribution:
- Fork the repo.
- Create a new branch.
- Commit your modifications.
- Push to the branch.
- Create a new pull request.



Happy cookin' with WhizzRecipe!
