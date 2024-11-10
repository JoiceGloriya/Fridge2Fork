CREATE TABLE recipes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  Title VARCHAR(255) NOT NULL,
  CookingMinutes INT,
  DairyFree BOOLEAN,
  GlutenFree BOOLEAN,
  Instructions TEXT,
  PreparationMinutes INT,
  PricePerServing DECIMAL(10,2),
  ReadyInMinutes INT,
  Servings INT,
  SpoonacularScore DECIMAL(5,2),
  Vegan BOOLEAN,
  Vegetarian BOOLEAN
);

INSERT INTO recipes (
  Title,
  CookingMinutes,
  DairyFree,
  GlutenFree,
  Instructions,
  PreparationMinutes,
  PricePerServing,
  ReadyInMinutes,
  Servings,
  SpoonacularScore,
  Vegan,
  Vegetarian
)
VALUES (
  "Roasted Salmon With Lime And Cilantro",
  10,
  true,
  true,
  "Preheat oven to 450 degrees. Arrange salmon in a shallow baking pan. Season with salt and pepper. Roast until no longer pink in the middle and flaky, 10 to 13 minutes. Using a flat spatula, remove fillets, leaving skin on the baking sheet.",
  5.0,
  427.92,
  15,
  4,
  99.0,
  false,
  false
); /*need to include a loop to iterate over recipe.text to incorporate all values*/
