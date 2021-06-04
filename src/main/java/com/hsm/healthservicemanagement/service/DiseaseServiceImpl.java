package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cg.hsm.entity.Address;
import com.hsm.healthservicemanagement.entity.Disease;
import com.hsm.healthservicemanagement.repository.IDiseaseRepository;

//implementation of service layer method by extending that method
@Service
public class DiseaseServiceImpl implements IDiseaseService {
	
	@Autowired
	IDiseaseRepository diseaseRepo;//Bean Object of service class
	// Used to store the given disease Object passes from the controller
	
	private Integer diseaseId;
	
	//Logger declare
	  org.apache.logging.log4j.Logger logger = LogManager.getLogger(DiseaseServiceImpl.class);
	  
	// Get a specific details from disease of the given Id
	// findDiseaseById
	@Override
	public Disease findByDiseaseId(int id) {
		// setting logger info
		logger.info("Get the disease details By Id");
		Optional<Disease> disease = diseaseRepo.findById(id);
		if(!disease.isPresent()) {
			return null;
		}
		return disease.get();
	}
	// Used to get list of all the disease from the database
	// findAllDiseaseDetails
	@Override
	public List<Disease> findAll() {
		// setting logger info
		logger.info("Find the details of the disease");
		return diseaseRepo.findAll();
	}
	// Get a specific disease of the given ID
	// findDiseaseById
	@Override
	public Disease update(Disease disease) {
		// setting logger info
		logger.info("update the details of the disease");

		Optional<Disease> diseases= diseaseRepo.findById(disease.getDiseaseId());
		if(!diseases.isPresent()) {
			return null;
		}
		diseases.get().setDiseaseName(disease.getDiseaseName());
		diseases.get().setDiseaseType(disease.getDiseaseType());
		diseases.get().setDiseaseSymptoms(disease.getDiseaseSymptoms());
		return diseaseRepo.save(diseases.get());
	}
	//Used to store the given disease object passes from the controller
	//save
	@Override
	public Disease save(Disease disease) {

		// setting logger info
		logger.info("save the details of the disease");
		return diseaseRepo.save(disease);
	}
	
	
	// Used to update the disease type
	// updateDiseaseType
	@Override
	public Disease updateDiseaseType(int diseaseId, Disease disease) {
		// setting logger info
		logger.info("update the Disease Type");
		Optional<Disease> diseases = diseaseRepo.findById(diseaseId);
		if(!diseases.isPresent()) {
			return null;
		}
		diseases.get().setDiseaseType(disease.getDiseaseType());
		return diseaseRepo.save(diseases.get());
	}
	// Get a specific disease of the given Symptoms
	// findDiseaseBySymptoms
	@Override
	public Disease updateDiseaseSymptoms(int diseaseId, Disease disease) {
		// setting logger info
		logger.info("update the Disease Symptoms");
		Optional<Disease> diseases = diseaseRepo.findById(diseaseId);
		if(!diseases.isPresent()) {
			return null;
		}
		diseases.get().setDiseaseSymptoms(disease.getDiseaseSymptoms());
		return diseaseRepo.save(diseases.get());
	}

	// Get a specific disease of the given Name
	// findDiseaseByName
	@Override
	public Disease updateDiseaseName(int diseaseId, Disease disease) {
		// setting logger info
		logger.info("update the Disease Name");
		Optional<Disease> diseases = diseaseRepo.findById(diseaseId);
		if(!diseases.isPresent()) {
			return null;
		}
		diseases.get().setDiseaseName(disease.getDiseaseName());
		return diseaseRepo.save(diseases.get());
	}
	//Used to delete the disease by id
	// deleteByDiseaseId
	@Override
	public Disease deleteByDiseaseId(int diseaseId) {

		// setting logger info
		logger.info(" delete the disease By Id");
		Optional<Disease> disease = diseaseRepo.findById(diseaseId);
		if(!disease.isPresent()) {
			return null;
		}
		diseaseRepo.deleteById(diseaseId);
		return disease.get();
	}

	@Override
	public Disease delete(Disease disease) {
		// setting logger info
		logger.info("delect the Disease ");
		diseaseRepo.delete(disease);
		return disease;
	}
	// Get a specific disease of the given ID
	//  updateDiseaseId
	@Override
	public Disease updateDiseaseId(int id, Disease disease) {
		// setting logger info
		logger.info("update the Disease ");
		Optional<Disease> diseases = diseaseRepo.findById(diseaseId);
		if(!diseases.isPresent()) {
			return null;
		}
		diseases.get().setDiseaseId(disease.getDiseaseId());
		return diseaseRepo.save(diseases.get());
	}
	//custom method//
	// find a specific disease of the given Name
	//  findByDiseaseName
	@Override
	public Disease findByDiseaseName(String name) {
		// setting logger info
		logger.info("Get the disease details By Name");
		return diseaseRepo.findByDiseaseName(name);
	}
	// find a specific disease id which is lesser than
	//  findByDiseaseIdLessThan
	@Override
	public List<Disease> findByDiseaseIdLessThan(int id) {
		// setting logger info
		logger.info("Get the disease details By Id that is lesser than");
		return diseaseRepo.findByDiseaseIdLessThan(id);
	}
	
}