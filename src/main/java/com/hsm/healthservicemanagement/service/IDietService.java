package com.hsm.healthservicemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Diet;

@Service
public interface IDietService {

	// save diet
	public Diet save(Diet diet);

	// deleteDietByDietId
	public Diet deleteDiet(int id);

	// viewAllDietDetails
	public List<Diet> viewAll();

	// viewDietByDietId
	public Diet viewDietById(int id);

	// update
	public Diet updateDiet(Diet diet);

	// updateDietByDietId
	public Diet updateDietType(int id, Diet diet);
	
	// delete diet
	public Diet delete(Diet diet);


}
