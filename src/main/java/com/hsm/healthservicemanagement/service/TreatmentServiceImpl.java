package com.hsm.healthservicemanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Treatment;
import com.hsm.healthservicemanagement.entity.TreatmentStatus;
import com.hsm.healthservicemanagement.repository.ITreatmentRepository;

@Service
public class TreatmentServiceImpl implements ITreatmentService {

	@Autowired
	ITreatmentRepository treatmentRepo;
	
	//save
	@Override
	public Treatment save(Treatment treatment) {
		return treatmentRepo.save(treatment);
	}
	
	//findAllTreatment
	@Override
	public List<Treatment> findAllTreatment() {
		return treatmentRepo.findAll();
	}

	// findByTreatmentId
	@Override
	public Treatment findByTreatmentId(int treatmentId) {
		return treatmentRepo.findByTreatmentId(treatmentId);
	}

	// findByTreatmentDate
	@Override
	public List<Treatment> findByTreatmentDate(LocalDate treatmentDate) {
		return  treatmentRepo.findByTreatmentDate(treatmentDate);
	}
	
    //findByTreatmentStatus
	@Override
	public List<Treatment> findByTreatmentStatus(TreatmentStatus treatmentStatus) {
		return treatmentRepo.findByTreatmentStatus(treatmentStatus);
		 
	} 


	@Override
	public Treatment deleteTreatmentByTreatmentId(int treatmentId) {
		Optional<Treatment> opt = treatmentRepo.findById(treatmentId);
		if (!opt.isPresent()) {
			return null;
		}
		Treatment t = opt.get();
		treatmentRepo.deleteById(treatmentId);
		return t;
	}
	
	
	//updateAll
	@Override
	public Treatment updateTreatment(Treatment treatment) {
		Treatment t = treatmentRepo.findByTreatmentId(treatment.getTreatmentId());
		t.setCurrentTreatment(treatment.getCurrentTreatment());
		t.setTreatmentDate(treatment.getTreatmentDate());
		t.setTreatmentFee(treatment.getTreatmentFee());
		t.setTreatmentId(treatment.getTreatmentId());
		return treatmentRepo.save(t);
	}
	
	//update TreatmentDateByTreatmentId
	@Override
	public Treatment updateTreatmentDateByTreatmentId(int treatmentId,Treatment treatment) {
		Treatment t= treatmentRepo.findByTreatmentId(treatmentId);
		t.setTreatmentDate(treatment.getTreatmentDate());
		return treatmentRepo.save(t);
	}

	@Override
		public Treatment updateTreatmentStatusByTreatmentId(int treatmentId,Treatment treatment) {
			Treatment t= treatmentRepo.findByTreatmentId(treatmentId);
			t.setTreatmentStatus(treatment.getTreatmentStatus());
			return treatmentRepo.save(t);
	}
}