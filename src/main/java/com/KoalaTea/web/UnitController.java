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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.KoalaTea.model.Ingredient;
import com.KoalaTea.model.Joke;
import com.KoalaTea.model.restModel.SpoonacularIngredient;
import com.KoalaTea.model.restModel.SpoonacularRecipe;
import com.KoalaTea.model.restModel.SpoonacularError;
import com.KoalaTea.model.Unit;
import com.KoalaTea.service.UnitService;


@CrossOrigin
@RestController
@RequestMapping(value="/unit")
public class UnitController {

	private UnitService unitService;
	
	@Autowired
	public void setMovieService(UnitService us) {
		this.unitService = us;
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHome() {
		return "index";
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Unit> getAllMovies(){
		return unitService.getAllUnits();
	}
	
	@PostMapping(value="/insert")
	public void insertMovie(@RequestBody Unit u) {
		unitService.insertUnit(u);
	}
	
	@GetMapping(value="/{id}")
	public Unit getMovieById(@PathVariable int id) {
		return unitService.getUnitById(id);
	}
	
	@GetMapping(value="/byId")
	public Unit getMovieByIdAgain(@RequestParam int id) {
		return unitService.getUnitById(id);
	}
	
	@GetMapping(value="/joke")
	public Joke getRandomJoke() {
		return Rest.getRandomFoodJoke();
	}
	
	@GetMapping(value="/spoonError")
	public SpoonacularError getSpoon() {
		return Rest.getSpoon();
	}
	
	@GetMapping(value="/spoonIngredient")
	public SpoonacularIngredient getSpoonIngredient() {
		return Rest.getSpoonIngredient();
	}
	
	@GetMapping(value="/spoonRecipe")
	public SpoonacularRecipe getSpoonRecipe() {
		return Rest.getSpoonRecipe();
	}
}
