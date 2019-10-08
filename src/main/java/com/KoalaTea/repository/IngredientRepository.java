package com.KoalaTea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KoalaTea.model.Ingredient;
import com.KoalaTea.model.Recipe;

@Repository(value="ingredientRepository")
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	public List<Ingredient> findAll();
	public Ingredient findById(int id);
	public List<Ingredient> findByrecipe(Recipe recipe);
	public <S extends Ingredient> S save(List<Ingredient> i);
}
