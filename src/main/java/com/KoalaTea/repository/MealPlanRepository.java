package com.KoalaTea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KoalaTea.model.MealPlan;
import com.KoalaTea.model.User;

@Repository(value="mealplanRepository")
public interface MealPlanRepository extends JpaRepository<MealPlan, Integer> {

	public List<MealPlan> findAll();
	public MealPlan findById(int id);
	public MealPlan findByUser(User user);
	public <S extends MealPlan> S save(S mp);
	public void delete(MealPlan mp);
}
