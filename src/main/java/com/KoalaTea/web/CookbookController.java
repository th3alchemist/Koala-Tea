package com.KoalaTea.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KoalaTea.model.CookBook;
import com.KoalaTea.service.CookbookService;

@CrossOrigin
@RestController
@RequestMapping(value="/cookbook")
public class CookbookController {
	
	@Autowired
	private CookbookService cookbookService;
	
	public void setUserService(CookbookService cookbookService) {
		this.cookbookService = cookbookService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CookBook> getAllCookbook(){
		return cookbookService.findAll();
	}
	
	@PostMapping(value="/insert")
	public void insertCookbook(@RequestBody CookBook c) {
		cookbookService.insertCookbook(c);
	}
	
	@GetMapping(value="/{id}")
	public CookBook getCookbookById(@PathVariable int id) {
		return cookbookService.findById(id);
	}
	
	@GetMapping(value="/byUserId")
	public CookBook getCookbookByUserId(@RequestParam int id) {
		return cookbookService.findByUserId(id);
	}
	
}
