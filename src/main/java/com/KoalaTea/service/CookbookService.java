package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.CookBook;
import com.KoalaTea.model.User;
import com.KoalaTea.repository.CookbookRepository;

@Service(value="cookbookService")
public class CookbookService {

	@Autowired
	CookbookRepository cookbookRepository;
	
	public List<CookBook> findAll(){		
		return cookbookRepository.findAll();
	}
	
	public CookBook findById(int id) {
		return cookbookRepository.findById(id);
	}
	
	public List<CookBook> findByUser(User user) {
		return cookbookRepository.findByUser(user);
	}
	
	public CookBook insertCookbook(CookBook c) {
		return cookbookRepository.save(c);
	}
	
	public void deleteCookbook(CookBook c) {
		cookbookRepository.delete(c);
	}
}
