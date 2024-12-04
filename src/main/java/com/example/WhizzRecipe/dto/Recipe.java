package com.example.WhizzRecipe.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(name = "CookingMinutes")
	private Integer cookingMinutes;
	@Column(name = "DairyFree")
	private Boolean dairyFree;
	@Column(name = "GlutenFree")
	private Boolean glutenFree;
	@Column(name = "instructions", columnDefinition = "TEXT")
	private String instructions;
	@Column(name = "PreparationMinutes")
	private Double preparationMinutes;
	@Column(name = "PricePerServing")
	private Double pricePerServing;
	@Column(name = "ReadyInMinutes")
	private Integer readyInMinutes;
	@Column(name = "Servings")
	private Integer servings;
	@Column(name = "SpoonacularScore")
	private Double spoonacularScore;
	@Column(name = "Title")
	private String title;
	@Column(name = "Vegan")
	private Boolean vegan;
	@Column(name = "Vegetarian")
	private Boolean vegetarian;
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
	@Column(name = "ingredient")
	private List<String> ingredients;
	private String imageUrl;



	private List<String> dietLabels;
	private List<String> healthLabels;
	private List<String> cautions;
	private double calories;
	private double totalWeight;
	private int totalTime;
	private List<String> cuisineType;
	private List<String> mealType;
	private List<String> dishType;

	public List<String> getDishType() {
		return dishType;
	}

	public void setDishType(List<String> dishType) {
		this.dishType = dishType;
	}

	public Recipe(String label, String url) {
		this.title = label;
		this.instructions = url;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", cookingMinutes=" + cookingMinutes + ", dairyFree=" + dairyFree +
				", glutenFree=" + glutenFree + ", instructions=" + instructions +
				", preparationMinutes=" + preparationMinutes + ", pricePerServing=" + pricePerServing +
				", readyInMinutes=" + readyInMinutes + ", servings=" + servings +
				", spoonacularScore=" + spoonacularScore + ", title=" + title +
				", vegan=" + vegan + ", vegetarian=" + vegetarian + "]";
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public List<String> getCautions() {
		return cautions;
	}

	public void setCautions(List<String> cautions) {
		this.cautions = cautions;
	}

	public List<String> getDietLabels() {
		return dietLabels;
	}

	public void setDietLabels(List<String> dietLabels) {
		this.dietLabels = dietLabels;
	}

	public List<String> getMealType() {
		return mealType;
	}

	public void setMealType(List<String> mealType) {
		this.mealType = mealType;
	}

	public List<String> getHealthLabels() {
		return healthLabels;
	}

	public void setHealthLabels(List<String> healthLabels) {
		this.healthLabels = healthLabels;
	}

	public List<String> getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(List<String> cuisineType) {
		this.cuisineType = cuisineType;
	}
}
