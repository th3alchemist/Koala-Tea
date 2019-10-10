package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.Meal;
import com.KoalaTea.model.MealPlan;
import com.KoalaTea.repository.MealRepository;

@Service(value="mealService")
public class MealService {

	@Autowired
	MealRepository mealRepository;
	
	public List<Meal> findAll(){		
		return mealRepository.findAll();
	}
	
	public Meal findById(int id) {
		return mealRepository.findById(id);
	}
	
	public List<Meal> findByMealPlan(MealPlan mp) {
		return mealRepository.findByMealPlan(mp);
	}
	
	public List<Meal> insertMeal(List<Meal> m) {
		return mealRepository.saveAll(m);
	}
	
//	public Meal updateMeal(Meal m) {
//		return mealRepository.save(m);
//	}
	
	public void deleteMeal(Meal m) {
		mealRepository.delete(m);
	}
}
