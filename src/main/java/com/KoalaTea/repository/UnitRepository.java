package com.KoalaTea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KoalaTea.model.Unit;


@Repository(value="unitRepository")
public interface UnitRepository extends JpaRepository<Unit, Integer>{
	
	public List<Unit> findAll();
	public Unit findById(int id);
	public <S extends Unit> S save(Unit u);
}
