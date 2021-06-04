package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Finance;
import com.hsm.healthservicemanagement.repository.IFinanceRepository;

//Implementation of service layer method by extending that method
@Service
public class FinanceServiceImpl implements IFinanceService {

	// Bean Object of service class
	@Autowired
	IFinanceRepository financeRepo;

	// Logger declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DietServiceImpl.class);

	// Get a the details from finance of the given ID
	// findByFinanceId
	@Override
	public Finance findByFinanceId(int financeId) {
		// setting logger info
		logger.info("Found finance by ID details sucessfully");
		Optional<Finance> opt = financeRepo.findById(financeId);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	// Used to get list of all the finance from the database
	// findAllFinanceDetails
	@Override
	public List<Finance> findAllFinanceDetails() {
		// setting logger info
		logger.info("Found all the finance details sucessfully");
		return financeRepo.findAll();
	}

	// Used to store the given finance object passes from the controller
	// save
	@Override
	public Finance save(Finance finance) {
		// setting logger info
		logger.info("Saved the finance details sucessfully!");
		return financeRepo.save(finance);
	}

	// Used to delete the finance by id
	// deleteFinanceByFinanceId
	@Override
	public Finance deleteFinanceByFinanceId(int financeId) {
		// setting logger info
		logger.info(" Deleted Finance By Id sucessfully");
		Optional<Finance> opt = financeRepo.findById(financeId);
		if (!opt.isPresent()) {
			return null;
		}
		Finance fin = opt.get();
		financeRepo.deleteById(financeId);
		return fin;
	}

	// Used to update the finance details
	// put // keep the same name and Id and change the set of the details
	// updateFinance
	@Override
	public Finance updateFinance(Finance finance) {
		// setting logger info
		logger.info("Updated sucessfully");
		Optional<Finance> fin = financeRepo.findById(finance.getFinanceId());
		if (fin.isPresent()) {

			fin.get().setPatientName(finance.getPatientName());
			fin.get().setRegistrationFee(finance.getRegistrationFee());
			fin.get().setDoctorFee(finance.getDoctorFee());
			fin.get().setMedicinesAmount(finance.getMedicinesAmount());
			fin.get().setTotalFee(finance.getTotalFee());
		}
		return financeRepo.save(finance);
	}

	// custom method // findByPatientName
	@Override
	public List<Finance> findByPatientName(String patientName) {
		// setting logger info
		logger.info("Found by Patient Name Sucessfully");
		// Finance f = //financeRepo.findByPatientName(patientName).get();
		// return financeRepo.findByPatientName(patientName);
		return financeRepo.findByPatientName(patientName);
	}

}