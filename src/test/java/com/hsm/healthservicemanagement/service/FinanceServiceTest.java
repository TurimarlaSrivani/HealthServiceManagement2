package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Finance;

@SpringBootTest
class FinanceServiceTest {

	@Autowired
	IFinanceService financeService;

	// findAllFinanceDetails
	@Test
	void testFindAllFinanceDetails() {
		List<Finance> fin = financeService.findAllFinanceDetails();
		assertEquals(7, fin.size());
	}

	// save
	@Test
	void testSave() {
		Finance fin = new Finance(107, 40, "Vinay", 100, 10, 150, 7);

		Finance persistedFin = financeService.save(fin);
		assertEquals(107, persistedFin.getPatientId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(40, persistedFin.getRegistrationFee());
		assertEquals(100, persistedFin.getDoctorFee());
		assertEquals(10, persistedFin.getMedicinesAmount());
		assertEquals(150, persistedFin.getTotalFee());
		assertEquals(7, persistedFin.getFinanceId());
	}

	// findByPatientId
	@Test
	void testFindByPatientId() {
		Finance fin = financeService.findByPatientId(2);
		System.out.println(fin);
		assertEquals("ABhi", fin.getPatientName());
	}

	// deleteFinanceByPatientId
	@Test
	void testDeleteFinanceByPatientId() {
		Finance fin = new Finance(107, 40, "Vinay", 100, 10, 150, 7);
		Finance persistedFin = financeService.save(fin);

		assertEquals(107, persistedFin.getPatientId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(40, persistedFin.getRegistrationFee());
		assertEquals(100, persistedFin.getDoctorFee());
		assertEquals(10, persistedFin.getMedicinesAmount());
		assertEquals(150, persistedFin.getTotalFee());
		assertEquals(7, persistedFin.getFinanceId());
	}

	// updateFinance
	@Test
	void testUpdateFinance() {
		Finance fin = new Finance();
		fin.setPatientId(102);
		fin.setPatientName("ABhi");
		fin.setRegistrationFee(40);
		fin.setDoctorFee(60);
		fin.setMedicinesAmount(20);
		fin.setTotalFee(120);
		fin.setFinanceId(2);
		Finance update = financeService.updateFinance(fin);
		assertEquals(2, update.getFinanceId());
	}
	
}