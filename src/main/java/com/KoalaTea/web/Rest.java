package com.KoalaTea.web;


import org.springframework.web.client.RestTemplate;

import com.KoalaTea.model.Ingredient;
import com.KoalaTea.model.Joke;
import com.KoalaTea.model.restModel.SpoonacularError;
import com.KoalaTea.model.restModel.SpoonacularIngredient;
import com.KoalaTea.model.restModel.SpoonacularRecipe;
import com.KoalaTea.model.restModel.wrapper;

public class Rest {


	public static SpoonacularError getSpoon() {
		RestTemplate restTemplate = new RestTemplate();
		SpoonacularError sError  = restTemplate.getForObject("https://api.spoonacular.com/food/ingredients/9266/information", SpoonacularError.class);
		return sError;
	}
	
	public static SpoonacularIngredient getSpoonIngredient() {
		String url = "https://api.spoonacular.com/food/ingredients/" + "9266" +
				     "/information?apiKey=" + System.getenv("SPOON_API_KEY");
		
		RestTemplate restTemplate = new RestTemplate();

		SpoonacularIngredient ingredient  = restTemplate.getForObject(url, SpoonacularIngredient.class);
		return ingredient;
	}
	
	
	public static SpoonacularRecipe getSpoonRecipe() {
		String url = "https://api.spoonacular.com/recipes/search?number=1&apiKey=" +
				     System.getenv("SPOON_API_KEY");
		
		RestTemplate restTemplate = new RestTemplate();

		
		wrapper w = restTemplate.getForObject(url, wrapper.class);
		SpoonacularRecipe recipe = w.getResults().get(0);
		
		return recipe;
	}
	
	
	
	public static Joke getRandomFoodJoke() {
		String url = "https://api.spoonacular.com/food/jokes/random?apiKey=" + System.getenv("SPOON_API_KEY");
		RestTemplate restTemplate = new RestTemplate();
		
		Joke retrievedJoke = restTemplate.getForObject(url, Joke.class);
		return retrievedJoke;
	}	
}