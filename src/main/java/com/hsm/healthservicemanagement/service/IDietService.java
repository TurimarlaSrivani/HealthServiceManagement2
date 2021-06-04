package com.hsm.healthservicemanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hsm.healthservicemanagement.entity.Diet;

@Service
public interface IDietService // Service layer method
{
	// Method to be override by the implementing class
	// save diet
	public Diet save(Diet diet);

	// Method to be override by the implementing class
	// deleteDietByDietId
	public Diet deleteDiet(int id);

	// Method to be override by the implementing class
	// viewAllDietDetails
	public List<Diet> viewAll();

	// Method to be override by the implementing class
	// viewDietByDietId
	public Diet viewDietById(int id);

	// Method to be override by the implementing class
	// update
	public Diet updateDiet(Diet diet);

	// Method to be override by the implementing class
	// updateDietByDietId
	public Diet updateDietType(int id, Diet diet);

	// Method to be override by the implementing class
	// deleteDiet
	public Diet delete(Diet diet);
}
