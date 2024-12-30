package com.example.WhizzRecipe.repository;

import java.math.BigInteger;
import java.util.*;
import com.example.WhizzRecipe.dto.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, BigInteger> {
    List<Recipe> findByTitleContainingIgnoreCase(String title);

    List<Recipe> findByGlutenFreeTrue();

    List<Recipe> findByVeganTrue();

    List<Recipe> findByVegetarianTrue();

    List<Recipe> findByVeganTrueAndGlutenFreeTrue();

}

