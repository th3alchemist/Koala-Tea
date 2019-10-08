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
	
	public Meal findByMealPlan(MealPlan mp) {
		return mealRepository.findByMealPlan(mp);
	}
	
	public void insertMeal(Meal m) {
		mealRepository.save(m);
	}
	
	public void deleteMeal(Meal m) {
		mealRepository.delete(m);
	}
}
