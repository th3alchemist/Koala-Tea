package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.CookBook;
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
	
	public CookBook findByUserId(int id) {
		return cookbookRepository.findByUserid(id);
	}
	
	public void insertCookbook(CookBook c) {
		cookbookRepository.save(c);
	}
}
