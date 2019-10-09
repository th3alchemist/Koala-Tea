package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.Ingredient;
import com.KoalaTea.model.Recipe;
import com.KoalaTea.repository.IngredientRepository;


@Service(value="ingredientService")
public class IngredientService {

	@Autowired
	IngredientRepository ingredientRepository;

	
	public List<Ingredient> findAll(){		
		return ingredientRepository.findAll();
	}
	
	public Ingredient findById(int id) {
		return ingredientRepository.findById(id);
	}
	
	public List<Ingredient> findByrecipe(Recipe recipe){
		return ingredientRepository.findByrecipe(recipe);
	}
	public List<Ingredient> insertIngredient(List<Ingredient> i) {
		return ingredientRepository.saveAll(i);
	}
	
	public void updateIngredient(Ingredient i) {
		ingredientRepository.save(i);
	}
	
	public void deleteIngredient(Ingredient i) {
		ingredientRepository.delete(i);
	}
}
