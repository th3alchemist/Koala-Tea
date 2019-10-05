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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.KoalaTea.model.User;
import com.KoalaTea.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		System.out.println("here");
	
		return userService.findAll();
	}
	
	@PostMapping(value="/insert")
	public void insertUser(@RequestBody User u) {
		userService.insertUser(u);
	}
	
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.findById(id);
	}

	@GetMapping(value="/byId")
	public User getUserByIdAgain(@RequestParam int id) {
		return userService.findById(id);
	}
}
