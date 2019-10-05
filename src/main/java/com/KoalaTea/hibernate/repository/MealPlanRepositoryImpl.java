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
import com.revature.util.SessionFactory;

public class MealPlanRepositoryImpl {
	
	// create new meal plan
	public void insertMealPlan(MealPlan mealPlan) { // transient 
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(mealPlan); // persistent
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close(); // detached
		}
	}

	// select MealPlan by MealPlan id
	public MealPlan getMealPlanById(int id) {
		MealPlan MealPlan = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			MealPlan = s.get(MealPlan.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return MealPlan;
	}

	// select MealPlan by user id
	public MealPlan getMealPlanByUserId(int id) {
		MealPlan returnedMealPlan = null;
		Transaction tx = null;
		Session s = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<MealPlan> cq = cb.createQuery(MealPlan.class);
			Root<MealPlan> root = cq.from(MealPlan.class);
			
			cq.select(root).where(cb.equal(root.get("userid"), id));
			Query<MealPlan> q = s.createQuery(cq);
			returnedMealPlan = q.getSingleResult();
			
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return returnedMealPlan;
	}

	// update MealPlan
	public void updateMealPlan(MealPlan mealPlan) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.merge(mealPlan);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	// select all MealPlans by user id
	public List<MealPlan> selectAllMealPlansByUserId(int id) {
		List<MealPlan> returnedMealPlans = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<MealPlan> cq = cb.createQuery(MealPlan.class);
			Root<MealPlan> root = cq.from(MealPlan.class);
			
			cq.select(root).where(cb.equal(root.get("userid"), id));
			Query<MealPlan> q = s.createQuery(cq);
			returnedMealPlans = q.getResultList();
			
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return returnedMealPlans;
	}
	
	// delete MealPlan
		public void deleteMealPlan(MealPlan mealPlan) {
			Session s = null;
			Transaction tx = null;
			
			try {
				s = SessionFactory.getSession();
				tx = s.beginTransaction();
				s.delete(mealPlan);
				tx.commit();
			} catch(HibernateException e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				s.close();
			}
		}
	
}
