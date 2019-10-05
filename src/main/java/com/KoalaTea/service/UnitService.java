package com.KoalaTea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoalaTea.model.Unit;
import com.KoalaTea.repository.UnitRepository;

@Service(value="unitService")
public class UnitService {
	
	UnitRepository unitRepository;

	@Autowired
	public UnitService(UnitRepository ur) {
		this.unitRepository = ur;
	}
	
	public List<Unit> getAllUnits(){
		return unitRepository.findAll();
	}
	
	public void insertUnit(Unit m) {
		unitRepository.save(m);
	}
	
	public Unit getUnitById(int id) {
		return unitRepository.findById(id);
	}
}
