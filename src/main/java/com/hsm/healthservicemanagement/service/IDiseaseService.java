package com.hsm.healthservicemanagement.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Disease;

@Service
public interface IDiseaseService {

		// Method to be override by the implementing class
		// findByDiseaseId
		Disease findByDiseaseId(int id);
		// Method to be override by the implementing class
		// findAll
		List<Disease> findAll();
		// Method to be override by the implementing class
		// update
		Disease update(Disease disease);
		// Method to be override by the implementing class
		// save
		Disease save(Disease disease);
		// Method to be override by the implementing class
		// updateDiseaseType
		Disease updateDiseaseType(int diseaseId, Disease disease);
		// Method to be override by the implementing class
		// updateDiseaseSymptoms
		Disease updateDiseaseSymptoms(int diseaseId, Disease disease);
		// Method to be override by the implementing class
		// updateDiseaseName
		Disease updateDiseaseName(int diseaseId, Disease disease);
		// Method to be override by the implementing class
		// deleteByDiseaseId
		Disease deleteByDiseaseId(int diseaseId);
		// Method to be override by the implementing class
		// delete
		Disease delete(Disease disease);
		// Method to be override by the implementing class
		// updateDiseaseId
		Disease updateDiseaseId(int id, Disease disease);
		// Method to be override by the implementing class
		// updateDiseaseName
		Disease findByDiseaseName(String name);
		// Method to be override by the implementing class
		// findByDiseaseIdLessThan
		List<Disease> findByDiseaseIdLessThan(int id);

	}