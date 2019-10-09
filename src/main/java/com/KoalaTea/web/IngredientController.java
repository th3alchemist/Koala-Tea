package com.KoalaTea.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.KoalaTea.model.Ingredient;
import com.KoalaTea.model.Recipe;
import com.KoalaTea.service.IngredientService;

@CrossOrigin
@RestController
@RequestMapping(value="/ingredient")
public class IngredientController {
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Ingredient> getAllIngredient(){
		return ingredientService.findAll();
	}
	
	@PostMapping(value="/insert")
	public List<Ingredient> insertIngredient(@RequestBody List<Ingredient> i) {
		return ingredientService.insertIngredient(i);
	}
	
	@PostMapping(value="/update")
	public void updateIngredient(@RequestBody Ingredient i) {
		ingredientService.updateIngredient(i);
	}
	
	@GetMapping(value="/{id}")
	public Ingredient getIngredientById(@PathVariable int id) {
		return ingredientService.findById(id);  
	}

	@GetMapping(value="/byId")
	public Ingredient getIngredientByIdAgain(@RequestParam int id) {
		return ingredientService.findById(id);
	}
	
	@PostMapping(value="/byRecipe")
	public List<Ingredient> getIngredientsByRecipe(@RequestBody Recipe recipe) {
		return ingredientService.findByrecipe(recipe);
	}
	
	@PostMapping(value="/delete")
	public void deleteIngredient(@RequestBody Ingredient i) {
		ingredientService.deleteIngredient(i);
	}
}
