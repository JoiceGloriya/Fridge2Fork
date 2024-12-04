package com.example.WhizzRecipe.repository;

import java.math.BigInteger;
import java.util.*;
import com.example.WhizzRecipe.dto.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, BigInteger> {
    List<Recipe> findByTitleContainingIgnoreCase(String title); // For searching by title

    List<Recipe> findByGlutenFreeTrue(); // For gluten-free recipes

    List<Recipe> findByVeganTrue(); // For vegan recipes

    List<Recipe> findByVegetarianTrue(); // For vegetarian recipes

    List<Recipe> findByVeganTrueAndGlutenFreeTrue(); // For vegan and gluten-free recipes

}

