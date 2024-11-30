package com.example.WhizzRecipe.dto;

import jakarta.persistence.*;
import java.util.*;
import java.io.Serializable;

@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

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


	// Constructors
	public Recipe() {
	}

	public Recipe(String label, String url) {
		this.title = label;
		this.instructions = url;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCookingMinutes() {
		return cookingMinutes;
	}

	public void setCookingMinutes(Integer cookingMinutes) {
		this.cookingMinutes = cookingMinutes;
	}

	public Boolean getDairyFree() {
		return dairyFree;
	}

	public void setDairyFree(Boolean dairyFree) {
		this.dairyFree = dairyFree;
	}

	public Boolean getGlutenFree() {
		return glutenFree;
	}

	public void setGlutenFree(Boolean glutenFree) {
		this.glutenFree = glutenFree;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Double getPreparationMinutes() {
		return preparationMinutes;
	}

	public void setPreparationMinutes(Double preparationMinutes) {
		this.preparationMinutes = preparationMinutes;
	}

	public Double getPricePerServing() {
		return pricePerServing;
	}

	public void setPricePerServing(Double pricePerServing) {
		this.pricePerServing = pricePerServing;
	}

	public Integer getReadyInMinutes() {
		return readyInMinutes;
	}

	public void setReadyInMinutes(Integer readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}

	public Integer getServings() {
		return servings;
	}

	public void setServings(Integer servings) {
		this.servings = servings;
	}

	public Double getSpoonacularScore() {
		return spoonacularScore;
	}

	public void setSpoonacularScore(Double spoonacularScore) {
		this.spoonacularScore = spoonacularScore;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getVegan() {
		return vegan;
	}

	public void setVegan(Boolean vegan) {
		this.vegan = vegan;
	}

	public Boolean getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
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
}
