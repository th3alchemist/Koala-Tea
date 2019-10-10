package com.KoalaTea.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.KoalaTea.model.CookBook;
import com.KoalaTea.model.Recipe;
import com.KoalaTea.service.RecipeService;

@CrossOrigin
@RestController
@RequestMapping(value="/recipe")
public class RecipeController {
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Recipe> getAllRecipe(){
		return recipeService.findAll();
	}
	
	@PostMapping(value="/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	public Recipe insertRecipe(@RequestBody Recipe r, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			System.out.println("WE HAVE A SESSION!!");
			return recipeService.insertRecipe(r);
		} else {
			return null;
		}
		
	}
	
	@GetMapping(value="/{id}")
	public Recipe getRecipeById(@PathVariable int id) {
		return recipeService.findById(id);
	}

	@GetMapping(value="/byId")
	public Recipe getRecipeByIdAgain(@RequestParam int id) {
		return recipeService.findById(id);
	}
	
	@PostMapping(value="/byCookbook")
	public List<Recipe> getRecipeByCookBook(@RequestBody CookBook cookbook) {
		return recipeService.findByCookBook(cookbook);
	}
	
	@PostMapping(value="/delete")
	public void deleteRecipe(@RequestBody Recipe r) {
		recipeService.deleteRecipe(r);
	}
	
}
