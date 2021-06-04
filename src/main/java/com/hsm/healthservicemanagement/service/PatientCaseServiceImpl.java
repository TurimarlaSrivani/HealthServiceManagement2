package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.PatientCase;
import com.hsm.healthservicemanagement.repository.IPatientCaseRepository;

@Service
public class PatientCaseServiceImpl implements IPatientCaseService {

	// Implementation of service layer method by extend that method
	@Autowired
	IPatientCaseRepository patientRepository;

	// Used to store the given patientCase Object passes from the controller
	// save patientCase
	// Logger declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PatientCaseServiceImpl.class);

	@Override
	public PatientCase save(PatientCase PatientCase) {

		// setting logger info
		logger.info("save the details of the patientCase");
		return patientRepository.save(PatientCase);
	}

	// Used to delete the patientCase by id
	// deleteByPatientCaseId
	@Override
	public PatientCase deletePatientCase(int Id) {
		// setting logger info
		logger.info(" delete the delete PatientCase By Id");

		Optional<PatientCase> opt = patientRepository.findById(Id);
		if (!opt.isPresent()) {
			return null;
		}
		PatientCase pc = opt.get();
		patientRepository.deleteById(Id);
		return pc;
	}

	// Used to list all the patientCase from the database
	// viewAllPatientCaseDetails
	@Override
	public List<PatientCase> viewAll() {
		// setting logger info
		logger.info("Find the details of the patientCase");

		return patientRepository.findAll();
	}

	// Get a specific patientCase of the given Id
	// viewPatientCaseById
	@Override
	public PatientCase viewPatientCaseById(int Id) {
		// setting logger info
		logger.info("Get the patientCase details By Id");

		Optional<PatientCase> opt = patientRepository.findById(Id);
		if (!opt.isPresent()) {
			return null;
		}

		return opt.get();
	}

	// Used to update the patientCase type of given id and object
	// updatePatientCaseDetails
	@Override
	public PatientCase update(PatientCase PatientCase) {
		// setting logger info
		logger.info("update the patientCase details ");

		Optional<PatientCase> opt = patientRepository.findById(PatientCase.getPatientCaseId());
		if (!opt.isPresent()) {
			return null;
		}

		PatientCase pc = opt.get();
		pc.setAssociateDoctorName(PatientCase.getAssociateDoctorName());
		pc.setMedicineFee(PatientCase.getMedicineFee());
		pc.setAppointmentDate(PatientCase.getAppointmentDate());
		pc.setCurrentTreatment(PatientCase.getCurrentTreatment());

		pc.setPatientCaseId(PatientCase.getPatientCaseId());
		pc.setPatientId(PatientCase.getPatientId());
		pc.setMedicines(PatientCase.getMedicines());
		return patientRepository.save(pc);
	}

	// Used to update the patientCase by id
	// updatePatientCaseById
	@Override
	public PatientCase updateById(int Id, PatientCase PatientCase) {
		// setting logger info
		logger.info("update the patientCase details by id");

		Optional<PatientCase> opt = patientRepository.findById(Id);
		if (!opt.isPresent()) {
			return null;
		}
		PatientCase pc = opt.get();
		pc.setMedicines(PatientCase.getMedicines());
		return patientRepository.save(pc);
	}

}
