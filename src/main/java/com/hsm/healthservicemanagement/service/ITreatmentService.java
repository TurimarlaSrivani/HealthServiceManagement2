package com.hsm.healthservicemanagement.service;

import java.time.LocalDate;
import java.util.List;

import com.hsm.healthservicemanagement.entity.Treatment;
import com.hsm.healthservicemanagement.entity.TreatmentStatus;

public interface ITreatmentService {

	// save
	Treatment save(Treatment treatment);

	// findAllTreatmentDetails
	List<Treatment> findAllTreatment();

	// findByTreatmentId
	Treatment findByTreatmentId(int treatmentId);

	// findByTreatmentDate
	List<Treatment> findByTreatmentDate(LocalDate treatmentDate);
	
	//findByTreatmentStatus
	List<Treatment> findByTreatmentStatus(TreatmentStatus treatmentStatus); 
	
	// deleteTreatmentByTreatmentId
	Treatment deleteTreatmentByTreatmentId(int treatmentId);

	// updateTreatment
	Treatment updateTreatment(Treatment treatment);
    
	//updateTreatmentDateByTreatmentId
	Treatment updateTreatmentDateByTreatmentId(int treatmentId, Treatment treatment);
	
	//updateTreatmentStatusByTreatmentId
	Treatment updateTreatmentStatusByTreatmentId(int treatmentId, Treatment treatment);
}