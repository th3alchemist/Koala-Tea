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

import com.revature.model.CookBook;
import com.revature.util.SessionFactory;

public class CookBookRepositoryImpl {
	
	// create new cookbook
	public void insertCookBook(CookBook CookBook) { // transient 
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(CookBook); // persistent
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close(); // detached
		}
	}

	// select CookBook by CookBook id
	public CookBook getCookBookById(int id) {
		CookBook CookBook = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			CookBook = s.get(CookBook.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return CookBook;
	}

	// select CookBook by user id
	public CookBook getCookBookByUserId(int id) {
		CookBook returnedCookBook = null;
		Transaction tx = null;
		Session s = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<CookBook> cq = cb.createQuery(CookBook.class);
			Root<CookBook> root = cq.from(CookBook.class);
			
			cq.select(root).where(cb.equal(root.get("userid"), id));
			Query<CookBook> q = s.createQuery(cq);
			returnedCookBook = q.getSingleResult();
			
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return returnedCookBook;
	}

	// update CookBook
	public void updateCookBook(CookBook CookBook) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.merge(CookBook);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	// select all CookBooks by user id
	public List<CookBook> selectAllCookBooksByUserId(int id) {
		List<CookBook> returnedCookBooks = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<CookBook> cq = cb.createQuery(CookBook.class);
			Root<CookBook> root = cq.from(CookBook.class);
			
			cq.select(root).where(cb.equal(root.get("userid"), id));
			Query<CookBook> q = s.createQuery(cq);
			returnedCookBooks = q.getResultList();
			
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return returnedCookBooks;
	}
	
	// delete CookBook
		public void deleteCookBook(CookBook CookBook) {
			Session s = null;
			Transaction tx = null;
			
			try {
				s = SessionFactory.getSession();
				tx = s.beginTransaction();
				s.delete(CookBook);
				tx.commit();
			} catch(HibernateException e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				s.close();
			}
		}
	
}
