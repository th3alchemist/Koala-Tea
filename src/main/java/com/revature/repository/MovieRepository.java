package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Movie;

/*
 * The JPARepository is an extension of the CRUDRepository. It is designed to wrap
 * around an ORM framework (Hibernate in our case) and implement the methods in our
 * repository layer under the hood. We need only create an interface and extend the
 * JPA Repository.
 * 
 * The JpaRepository takes generics. The first denotes the entity which we will be working
 * with. The second one denotes the type of the unique
 * identifier (so primary key). 
 */

@Repository(value="movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	/*
	 * These methods here are already implemented for us under the hood. We need
	 * only declare them on this interface.
	 */
	public List<Movie> findAll();
	public Movie findById(int id);
	public <S extends Movie> S save(Movie m);
	
}
