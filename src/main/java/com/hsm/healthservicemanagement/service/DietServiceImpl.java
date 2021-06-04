package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Diet;
import com.hsm.healthservicemanagement.repository.IDietRepository;

@Service
public class DietServiceImpl implements IDietService   //Implementation of service layer method by extend that method
{
	
	@Autowired
	IDietRepository drepository; //Bean Object of service class
	// Used to store the given diet Object passes from the controller
	// save diet
	
	 //Logger declare
	  org.apache.logging.log4j.Logger logger = LogManager.getLogger(DietServiceImpl.class);
	  
	@Override
	public Diet save(Diet diet) {
		
		// setting logger info
		logger.info("save the details of the diet");
		return drepository.save(diet);
	}
    
	//Used to delete the diet by id
	// deleteByDietId
	@Override    
	public Diet deleteDiet(int id) {
		
		
		// setting logger info
		logger.info(" delete the Diet By Id");

		Optional<Diet> opt = drepository.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		Diet d = opt.get();
		drepository.deleteById(id);
		return d;
	}
    
	// Used to list all the diet from the database
	// viewAllDietDetails
	@Override
	public List<Diet> viewAll() {
		
		// setting logger info
		logger.info("Find the details of the diet");

		return drepository.findAll();
	}
    
	// Get a specific diet of the given ID
	// viewDietById
	@Override
	public Diet viewDietById(int id) {
		// setting logger info
		logger.info("Get the diet detyails By Id");


		Optional<Diet> opt = drepository.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	// Used to update the diet type of given id and object
	// updateDietDetails
	@Override
	public Diet updateDiet(Diet diet) {
		// setting logger info
		logger.info("update the diet details by id");

		
		Optional<Diet> opt = drepository.findById(diet.getDietId());
		if (!opt.isPresent()) {
			return null;
		}
		Diet d = opt.get();
		d.setDietType(diet.getDietType());
		d.setFoodtoEat(diet.getFoodtoEat());
		d.setDietDuration(diet.getDietDuration());
		return drepository.save(d);
	}

	// Used to get diet by given type
	// updateDietType
	@Override
	public Diet updateDietType(int id, Diet diet) {
		
		// setting logger info
		logger.info("update the specific property by id");

		Optional<Diet> opt = drepository.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		Diet d = opt.get();
		d.setDietType(diet.getDietType());
		return drepository.save(d);
	}
    // Used to delete the diet
	// deleteDietDetails
	@Override
	public Diet delete(Diet diet) {
		drepository.delete(diet);
		return diet;
	}

}
