package com.example.WhizzRecipe.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.WhizzRecipe.dto.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
