package com.KoalaTea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KoalaTea.model.User;

@Repository(value="userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
	public User findById(int id);
	public <S extends User> S save(S u);
	
}
