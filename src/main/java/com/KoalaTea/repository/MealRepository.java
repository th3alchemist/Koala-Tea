package com.KoalaTea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KoalaTea.model.Meal;
import com.KoalaTea.model.MealPlan;

@Repository(value="mealRepository")
public interface MealRepository extends JpaRepository<Meal, Integer> {

	public List<Meal> findAll();
	public Meal findById(int id);
	public Meal findByMealPlan(MealPlan mp);
	public <S extends Meal> S save(S m);
	public void delete(Meal m);	
}
