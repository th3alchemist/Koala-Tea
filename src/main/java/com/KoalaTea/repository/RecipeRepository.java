package com.KoalaTea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KoalaTea.model.Recipe;

@Repository(value="recipeRepository")
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	public List<Recipe> findAll();
	public Recipe findById(int id);
	public <S extends Recipe> S save(Recipe r);
}
