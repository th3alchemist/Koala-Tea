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

import com.KoalaTea.model.MealPlan;
import com.KoalaTea.model.User;
import com.KoalaTea.service.MealPlanService;

@CrossOrigin
@RestController
@RequestMapping(value="/mealplan")
public class MealPlanController {

	@Autowired
	private MealPlanService mealplanService;
	
	public void setMealPlanService(MealPlanService mealplanService) {
		this.mealplanService = mealplanService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<MealPlan> getAllMealPlan(){
		return mealplanService.findAll();
	}
	
	@PostMapping(value="/insert")
	public void insertMealPlan(@RequestBody MealPlan mp) {
		mealplanService.insertMealPlan(mp);
	}
	
	@GetMapping(value="/{id}")
	public MealPlan getMealPlanById(@PathVariable int id) {
		return mealplanService.findById(id);
	}
	
	@PostMapping(value="/byUser")
	public MealPlan getMealPlanByUser(@RequestBody User user) {
		return mealplanService.findByUser(user);
	}
	
	@PostMapping(value="/delete")
	public void deleteMealPlan(@RequestBody MealPlan mp) {
		mealplanService.deleteMealPlan(mp);
	}
	
}
