package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.Finance;

public interface IFinanceService {

	// Service layer method
	// Method to be override by the implementing class
	// findByFinanceId
	public Finance findByFinanceId(int financeId);

	// findAllFinanceDetails
	public List<Finance> findAllFinanceDetails();

	// save
	public Finance save(Finance finance);

	// deleteFinanceByFinanceId
	public Finance deleteFinanceByFinanceId(int financeId);

	// updateFinance
	public Finance updateFinance(Finance finance);
	
	// custom methods // find based on patient name 
		List<Finance> findByPatientName(String patientName);

}