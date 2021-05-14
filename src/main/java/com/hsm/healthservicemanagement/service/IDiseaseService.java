package com.hsm.healthservicemanagement.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Disease;

@Service
public interface IDiseaseService {
	
		Disease findByDesId(int id);
		List<Disease> findAll();
		Disease update(Disease disease);
		Disease save(Disease disease);
		Disease updateDesType(int desId, Disease disease);
		Disease updateDesSym(int desId, Disease disease);
		Disease updateDesDur(int desId, Disease disease);
		Disease updateDesName(int desId, Disease disease);
		Disease deleteByDesId(int desId);
		Disease delete(Disease disease);
		Disease updateDesId(int id, Disease disease);
		Disease findByDesName(String name);
		
	
		

		// custom methods
		// find by name
		
		// Find emp's based on department
		
		List<Disease> findByDesIdLessThan(int id);
		
		


	}

			


