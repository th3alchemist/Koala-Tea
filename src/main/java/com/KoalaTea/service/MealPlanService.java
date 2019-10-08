package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.MealPlan;
import com.KoalaTea.model.User;
import com.KoalaTea.repository.MealPlanRepository;

@Service(value="mealplanService")
public class MealPlanService {

	@Autowired
	MealPlanRepository mealplanRepository;
	
	public List<MealPlan> findAll(){		
		return mealplanRepository.findAll();
	}
	
	public MealPlan findById(int id) {
		return mealplanRepository.findById(id);
	}
	
	public MealPlan findByUser(User user) {
		return mealplanRepository.findByUser(user);
	}
	
	public void insertMealPlan(MealPlan c) {
		mealplanRepository.save(c);
	}
	
	public void deleteMealPlan(MealPlan c) {
		mealplanRepository.delete(c);
	}
	
}
