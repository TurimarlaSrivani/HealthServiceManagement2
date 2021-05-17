package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Finance;
import com.hsm.healthservicemanagement.repository.IFinanceRepository;

@Service
public class FinanceServiceImpl implements IFinanceService {

	@Autowired
	IFinanceRepository financeRepo;

	// findByPatientId
	@Override
	public Finance findByPatientId(int patientId) {
		Optional<Finance> opt = financeRepo.findById(patientId);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	// findAllFinanceDetails
	@Override
	public List<Finance> findAllFinanceDetails() {
		return financeRepo.findAll();
	}

	// save
	@Override
	public Finance save(Finance finance) {
		return financeRepo.save(finance);
	}

	// deleteFinanceByPatientId
	@Override
	public Finance deleteFinanceByPatientId(int patientId) {
		Optional<Finance> opt = financeRepo.findById(patientId);
		if (!opt.isPresent()) {
			return null;
		}
		Finance fin = opt.get();
		financeRepo.deleteById(patientId);
		return fin;
	}

	// update
	@Override
	// put // keep the same name and Id and change the set of the details
	public Finance updateFinance(Finance finance) {
		Optional<Finance> fin = financeRepo.findById(finance.getFinanceId());
		if (fin.isPresent()) {
			fin.get().setPatientId(finance.getPatientId());
			fin.get().setPatientName(finance.getPatientName());
			fin.get().setRegistrationFee(finance.getRegistrationFee());
			fin.get().setDoctorFee(finance.getDoctorFee());
			fin.get().setMedicinesAmount(finance.getMedicinesAmount());
			fin.get().setTotalFee(finance.getTotalFee());
		}
		return financeRepo.save(finance);
	}

	// patch
	@Override
	public Finance updateFinanceByPatientName(int financeId, Finance finance) {
		Optional<Finance> fin = financeRepo.findById(financeId);
		if (fin.isPresent()) {
			fin.get().setPatientName(finance.getPatientName());
		}
		return financeRepo.save(finance);
	}

	@Override
	public Finance findByPatientName(String patientName) {
		return financeRepo.findByPatientName(patientName);
	}
}