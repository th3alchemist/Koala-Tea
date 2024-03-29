package com.KoalaTea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KoalaTea.model.CookBook;
import com.KoalaTea.model.User;

@Repository(value="cookbookRepository")
public interface CookbookRepository extends JpaRepository<CookBook, Integer>  {

	public List<CookBook> findAll();
	public CookBook findById(int id);
	public List<CookBook> findByUser(User user);
	public <S extends CookBook> S save(S c);
	public void delete(CookBook c);	 
}