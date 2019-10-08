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
import org.springframework.web.bind.annotation.RestController;

import com.KoalaTea.model.Meal;
import com.KoalaTea.model.MealPlan;
import com.KoalaTea.service.MealService;

@CrossOrigin
@RestController
@RequestMapping(value="/meal")
public class MealController {

	@Autowired
	private MealService mealService;
	
	public void setMealPlanService(MealService mealService) {
		this.mealService = mealService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Meal> getAllMeal(){
		return mealService.findAll();
	}
	
	@PostMapping(value="/insert")
	public void insertMeal(@RequestBody Meal m) {
		mealService.insertMeal(m);
	}
	
	@GetMapping(value="/{id}")
	public Meal getMealById(@PathVariable int id) {
		return mealService.findById(id);
	}
	
	@PostMapping(value="/byUser")
	public Meal getMealByMealPlan(@RequestBody MealPlan mp) {
		return mealService.findByMealPlan(mp);
	}
	
	@PostMapping(value="/delete")
	public void deleteMeal(@RequestBody Meal m) {
		mealService.deleteMeal(m);
	}
}
