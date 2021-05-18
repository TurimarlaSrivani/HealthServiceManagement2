package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Diet;
import com.hsm.healthservicemanagement.repository.IDietRepository;

@Service
public class DietServiceImpl implements IDietService {

	Logger logger = LogManager.getLogger("DietServiceImpl");

	@Autowired
	IDietRepository drepository;

	// save diet
	@Override
	public Diet save(Diet diet) {
		return drepository.save(diet);
	}

	// deleteByDietId
	@Override
	public Diet deleteDiet(int id) {
		Optional<Diet> opt = drepository.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		Diet d = opt.get();
		drepository.deleteById(id);
		return d;
	}

	// viewAllDietDetails
	@Override
	public List<Diet> viewAll() {
		return drepository.findAll();
	}

	// viewDietById
	@Override
	public Diet viewDietById(int id) {

		Optional<Diet> opt = drepository.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	// updateDietDetails
	@Override
	public Diet updateDiet(Diet diet) {
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

	// updateDietType
	@Override
	public Diet updateDietType(int id, Diet diet) {
		Optional<Diet> opt = drepository.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		Diet d = opt.get();
		d.setDietType(diet.getDietType());
		return drepository.save(d);
	}

	@Override
	public Diet delete(Diet diet) {
		drepository.delete(diet);
		return diet;
	}
}
