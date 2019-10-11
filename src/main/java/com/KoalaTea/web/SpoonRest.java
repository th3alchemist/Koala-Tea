package com.KoalaTea.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.client.RestTemplate;

import com.KoalaTea.model.Recipe;
import com.KoalaTea.model.Unit;
import com.KoalaTea.model.restModel.Joke;
import com.KoalaTea.model.restModel.SpoonNutritionInfo;
import com.KoalaTea.model.restModel.SpoonacularError;
import com.KoalaTea.model.restModel.SpoonacularIngredient;
import com.KoalaTea.model.restModel.SpoonacularRecipe;
import com.KoalaTea.model.restModel.SpoonacularRecipeResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "/spoon")
public class SpoonRest {

	@GetMapping(value="/joke")
	public static Joke getJoke() {
		String url = "https://api.spoonacular.com/food/jokes/random?apiKey=" + System.getenv("SPOON_API_KEY");

		RestTemplate restTemplate = new RestTemplate();
		Joke retrievedJoke = restTemplate.getForObject(url, Joke.class);
		return retrievedJoke;
	}

	@GetMapping(value="/error")
	public static SpoonacularError getSpoon() {
		String url = "https://api.spoonacular.com/food/jokes/random";

		RestTemplate restTemplate = new RestTemplate();
		SpoonacularError retrievedError = restTemplate.getForObject(url, SpoonacularError.class);
		return retrievedError;
	}

	@GetMapping(value="/ingredient")
	public static SpoonacularIngredient getSpoonIngredient() {
		String url = "https://api.spoonacular.com/food/ingredients/9266/information?apiKey="
				+ System.getenv("SPOON_API_KEY");

		RestTemplate restTemplate = new RestTemplate();
		SpoonacularIngredient retrievedIngredient = restTemplate.getForObject(url, SpoonacularIngredient.class);
		return retrievedIngredient;
	}
	
	@PostMapping(value="/recipe")
	public static SpoonacularRecipe getSpoonRecipe(@RequestBody String query) {
		String url = "https://api.spoonacular.com/recipes/search?apiKey="
				     + System.getenv("SPOON_API_KEY")
				     + "&" + query;
		
		RestTemplate restTemplate = new RestTemplate();
		SpoonacularRecipeResponse retrievedRecipe = restTemplate.getForObject(url, SpoonacularRecipeResponse.class);
				
		if(retrievedRecipe.getResults().size() == 0) {
			SpoonacularRecipe rtn =  new SpoonacularRecipe();
			rtn.setTitle("No recipe found.");
			return rtn;
		}
		else
			return retrievedRecipe.getResults().get(0);
	}
	
	
	@GetMapping(value="/recipe/{id}")
	public Object getRecipeById(@PathVariable int id) {
		String url = "https://api.spoonacular.com/recipes/" + id + "/information?apiKey=" + System.getenv("SPOON_API_KEY");
		
		RestTemplate restTemplate = new RestTemplate();
		Recipe retrievedRecipe = restTemplate.getForObject(url, Recipe.class);
		
		return retrievedRecipe;
	}
	
	@PostMapping(value="/nutritionInfo")
	public static SpoonNutritionInfo getSpoonNutritionInfo(@RequestBody String query) {
		String url = "https://api.spoonacular.com/recipes/quickAnswer?apiKey="
			     + System.getenv("SPOON_API_KEY")
			     + "&q=" + query;
		RestTemplate restTemplate = new RestTemplate();
		SpoonNutritionInfo retrievedInfo = restTemplate.getForObject(url, SpoonNutritionInfo.class);
		return retrievedInfo;
	}
}