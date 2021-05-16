package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.Finance;

public interface IFinanceService {

	// findByPatientId
	public Finance findByPatientId(int patientId);

	// findAllFinanceDetails
	public List<Finance> findAllFinanceDetails();

	// save
	public Finance save(Finance finance);

	// deleteFinanceByFinanceId
	public Finance deleteFinanceByPatientId(int patientId);

	// update
	public Finance updateFinance(Finance finance);

	public Finance updateFinanceByPatientName(int financeId, Finance finance);

	// custom queries
	public Finance findByPatientName(String patientName);
}
