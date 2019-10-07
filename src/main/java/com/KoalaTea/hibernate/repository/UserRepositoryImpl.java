package com.KoalaTea.hibernate.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class UserRepositoryImpl {
	
//	// create a new user
//	public void insertUser(User u) { // transient 
//		Session s = null;
//		Transaction tx = null;
//		
//		try {
//			s = SessionFactory.getSession();
//			tx = s.beginTransaction();
//			s.save(u); // persistent
//			System.out.println("save called in hibernate");
//			tx.commit();
//		} catch(HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			s.close(); // detached
//		}
//	}
//
//	// get user info by id
//	public User getUserById(int id) {
//		User u = null;
//		Session s = null;
//		Transaction tx = null;
//		
//		try {
//			s = SessionFactory.getSession();
//			tx = s.beginTransaction();
//			u = s.get(User.class, id);
//			tx.commit();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			s.close();
//		}
//		return u;
//	}
//	
////	get user info by email
//	public User getUserByEmail(String email) {
//		User returnedUser = null;
//		Transaction tx = null;
//		Session s = null;
//		
//		try {
//			s = SessionFactory.getSession();
//			tx = s.beginTransaction();
//			
//			CriteriaBuilder cb = s.getCriteriaBuilder();
//			CriteriaQuery<User> cq = cb.createQuery(User.class);
//			Root<User> root = cq.from(User.class);
//			
//			cq.select(root).where(cb.equal(root.get("email"), email));
//			Query<User> q = s.createQuery(cq);
//			
//			returnedUser = q.getSingleResult();
//			tx.commit();
//		} catch(HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			s.close();
//		}
//		return returnedUser;
//	}
//
////	update the user account
//	public void updateUser(User u) {
//		Session s = null;
//		Transaction tx = null;
//		
//		try {
//			s = SessionFactory.getSession();
//			tx = s.beginTransaction();
//			s.merge(u);
//			tx.commit();
//		} catch(HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			s.close();
//		}
//	}
//	
//	// delete user account
//	public void deleteUser(User u) {
//		Session s = null;
//		Transaction tx = null;
//		
//		try {
//			s = SessionFactory.getSession();
//			tx = s.beginTransaction();
//			s.delete(u);
//			tx.commit();
//		} catch(HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			s.close();
//		}
//	}
//	
//	
}
