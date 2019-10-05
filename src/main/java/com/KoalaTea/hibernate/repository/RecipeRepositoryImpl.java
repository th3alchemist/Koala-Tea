package com.KoalaTea.hibernate.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.MealPlan;
import com.revature.model.Recipe;
import com.revature.util.SessionFactory;

public class RecipeRepositoryImpl {
	
	// create recipe
	public void insertRecipe(Recipe recipe) { // transient 
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(recipe); // persistent
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close(); // detached
		}
	}

	// select recipe by recipe id
	public Recipe getRecipeById(int id) {
		Recipe recipe = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			recipe = s.get(Recipe.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return recipe;
	}

	// select recipe by user id
	public Recipe getRecipeByUserId(int id) {
		Recipe returnedRecipe = null;
		Transaction tx = null;
		Session s = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);
			Root<Recipe> root = cq.from(Recipe.class);
			
			cq.select(root).where(cb.equal(root.get("userid"), id));
			Query<Recipe> q = s.createQuery(cq);
			returnedRecipe = q.getSingleResult();
			
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return returnedRecipe;
	}

	// update recipe
	public void updateRecipe(Recipe recipe) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.merge(recipe);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	// select all recipes by user id
	public List<Recipe> selectAllRecipesByUserId(int id) {
		List<Recipe> returnedRecipes = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);
			Root<Recipe> root = cq.from(Recipe.class);
			
			cq.select(root).where(cb.equal(root.get("userid"), id));
			Query<Recipe> q = s.createQuery(cq);
			returnedRecipes = q.getResultList();
			
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return returnedRecipes;
	}
	
	// delete recipe
		public void deleteRecipe(Recipe recipe) {
			Session s = null;
			Transaction tx = null;
			
			try {
				s = SessionFactory.getSession();
				tx = s.beginTransaction();
				s.delete(recipe);
				tx.commit();
			} catch(HibernateException e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				s.close();
			}
		}
	
}
