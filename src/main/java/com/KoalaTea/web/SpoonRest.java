package com.KoalaTea.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.KoalaTea.model.restModel.Joke;
import com.KoalaTea.model.restModel.SpoonacularError;
import com.KoalaTea.model.restModel.SpoonacularIngredient;
import com.KoalaTea.model.restModel.SpoonacularRecipe;
import com.KoalaTea.model.restModel.SpoonacularRecipeResponse;

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

	@GetMapping(value="/recipe")
	public static SpoonacularRecipe getSpoonRecipe() {
		String url = "https://api.spoonacular.com/recipes/search?limit=1&apiKey="
				     + System.getenv("SPOON_API_KEY");

		RestTemplate restTemplate = new RestTemplate();
		SpoonacularRecipeResponse retrievedRecipe = restTemplate.getForObject(url, SpoonacularRecipeResponse.class);
		return retrievedRecipe.getResults().get(0);
	}
}