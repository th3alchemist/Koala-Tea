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
		return userService.findAll();
	}
	
	@PostMapping(value="/insert")
	public User insertUser(@RequestBody User u) {
		return userService.insertUser(u);
	}
	
	@PostMapping(value="/delete")
	public void deleteUser(@RequestBody User u) {
		userService.deleteUser(u);
	}
	
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.findById(id);
	}

	@GetMapping(value="/byId")
	public User getUserByIdAgain(@RequestParam int id) {
		return userService.findById(id);
	}
	
	@PostMapping(value="/login")
	public User validateLogin(@RequestParam String email, String password) {
		return userService.validateLogin(email, password);
	}
	
	@PostMapping(value="/login2")
	public User validateLogin2(@RequestBody User u) {
		System.out.println("entered login2 with user object");
//		return userService.validateLogin(u.getEmail(), u.getPassword());
		return null;
	}
}
