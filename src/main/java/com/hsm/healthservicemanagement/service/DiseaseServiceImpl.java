package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cg.hsm.entity.Address;
import com.hsm.healthservicemanagement.entity.Disease;
import com.hsm.healthservicemanagement.repository.IDiseaseRepository;

@Service
public class DiseaseServiceImpl implements IDiseaseService {

	@Autowired
	IDiseaseRepository desRepo;
	private Integer desId;
	
	@Override
	public Disease findByDesId(int id) {
		Optional<Disease> des = desRepo.findById(id);
		if(!des.isPresent()) {
			return null;
		}
		return des.get();
	}

	@Override
	public List<Disease> findAll() {
		return desRepo.findAll();
	}

	@Override
	public Disease update(Disease disease) {
		Optional<Disease> des = desRepo.findById(disease.getDesId());
		if(!des.isPresent()) {
			return null;
		}
		des.get().setDesName(disease.getDesName());
		des.get().setDesName(disease.getDesName());
		return desRepo.save(des.get());
	}

	@Override
	public Disease save(Disease disease) {
		return desRepo.save(disease);
	}

	@Override
	public Disease updateDesType(int desId, Disease disease) {
		Optional<Disease> des = desRepo.findById(desId);
		if(!des.isPresent()) {
			return null;
		}
		des.get().setDesType(disease.getDesType());
		return desRepo.save(des.get());
	}

	@Override
	public Disease updateDesSym(int desId, Disease disease) {
		Optional<Disease> des = desRepo.findById(desId);
		if(!des.isPresent()) {
			return null;
		}
		des.get().setDesSym(disease.getDesSym());
		return desRepo.save(des.get());
	}

	@Override
	public Disease updateDesDur(int desId, Disease disease) {
		Optional<Disease> des = desRepo.findById(desId);
		if(!des.isPresent()) {
			return null;
		}
		des.get().setDesDur(disease.getDesDur());
		return desRepo.save(des.get());
	}

	@Override
	public Disease updateDesName(int desId, Disease disease) {
		Optional<Disease> des = desRepo.findById(desId);
		if(!des.isPresent()) {
			return null;
		}
		des.get().setDesDur(disease.getDesDur());
		return desRepo.save(des.get());
	}

	@Override
	public Disease deleteByDesId(int desId) {
		Optional<Disease> des = desRepo.findById(desId);
		if(!des.isPresent()) {
			return null;
		}
		desRepo.deleteById(desId);
		return des.get();
	}

	@Override
	public Disease delete(Disease disease) {
		desRepo.delete(disease);
		return disease;
	}

	@Override
	public Disease updateDesId(int id, Disease disease) {
		Optional<Disease> des = desRepo.findById(desId);
		if(!des.isPresent()) {
			return null;
		}
		des.get().setDesId(disease.getDesId());
		return desRepo.save(des.get());
	}

	@Override
	public Disease findByDesName(String name) {
		return desRepo.findByDesName(name);
	}

	@Override
	public List<Disease> findByDesIdLessThan(int id) {
		return desRepo.findByDesIdLessThan(id);
	}

	


	
}
