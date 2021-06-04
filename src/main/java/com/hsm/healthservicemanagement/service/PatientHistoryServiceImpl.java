package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.PatientHistory;
import com.hsm.healthservicemanagement.repository.IPatientHistoryRepository;

@Service
//Implementation of service layer method by extend that method
public class PatientHistoryServiceImpl implements IPatientHistoryService {
	// Logger declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PatientHistoryServiceImpl.class);

	@Autowired
	IPatientHistoryRepository repository; // Bean Object of service class

	// Used to store the given patientHistory Object passes from the controller
	// addPatientHistory
	@Override
	public PatientHistory addPatientHistory(PatientHistory history) {
		logger.info("Save the details of the patient history");
		return repository.save(history);
	}

	// Get a specific patient history of the given ID
	// findByPatientHistoryId
	@Override
	public PatientHistory findByPatientHistoryId(int patientHistoryId) {
		// setting logger info
		logger.info("Get the patient history details By Id");
		Optional<PatientHistory> history = repository.findById(patientHistoryId);
		if (!history.isPresent()) {
			return null;
		}
		return history.get();
	}

	// Used to delete the patient history by id
	// deleteByPatientHistoryId
	@Override
	public String deleteByPatientHistoryId(int patientHistoryId) {
		// setting logger info
		logger.info("Delete the delete patient history By Id");
		Optional<PatientHistory> history = repository.findById(patientHistoryId);
		if (!history.isPresent()) {
			return null;
		}
		// PatientHistory p=his.get();
		repository.deleteById(patientHistoryId);
		// System.out.print("Successfully deleted :" + patientHistoryId);
		return patientHistoryId + "";

	}

	// Used to update the patient history of given id and object
	// updatePatientHistory
	public PatientHistory updatePatientHistory(PatientHistory his) {
		// setting logger info
		logger.info("Update the patient history details by id");
		Optional<PatientHistory> history = repository.findById(his.getPatientHistoryId());
		if (!history.isPresent()) {
			return null;
		}
		PatientHistory p = history.get();
		// p.setPatientId(his.getPatientId());
		p.setRecordedDate(his.getRecordedDate());
		return repository.save(p);
	}

	// Used to list all the patient history from the database
	// getAllPatientHistory
	@Override
	public List<PatientHistory> getAllPatientHistory() {
		// setting logger info
		logger.info("Find the details of the patient history");
		return repository.findAll();
	}

}