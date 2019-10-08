package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.CookBook;
import com.KoalaTea.model.Recipe;
import com.KoalaTea.repository.RecipeRepository;

@Service(value="recipeService")
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepository;

	
	public List<Recipe> findAll(){		
		return recipeRepository.findAll();
	}
	
	public Recipe findById(int id) {
		return recipeRepository.findById(id);
	}
	public List<Recipe> findBycookBook(CookBook cookBook) {
		return recipeRepository.findBycookBook(cookBook);
	}
	
	public void insertRecipe(Recipe r) {
		recipeRepository.save(r);
	}
}
