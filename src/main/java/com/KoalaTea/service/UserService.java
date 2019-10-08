package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.User;
import com.KoalaTea.repository.UserRepository;

@Service(value="userService")
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){		
		return userRepository.findAll();
	}
	
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	public void insertUser(User u) {
		userRepository.save(u);
	}
	
	public void deleteUser(User u) {
		userRepository.delete(u);
	}
}
