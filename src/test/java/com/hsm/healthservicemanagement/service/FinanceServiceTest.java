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
		assertEquals(6, fin.size());
	}

	// save
	@Test
	void testSave() {
		Finance fin = new Finance(6,106,"Vinay",400,30,20,490);
		
		Finance persistedFin = financeService.save(fin);
		
		assertEquals(106, persistedFin.getPatientId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(30, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(490, persistedFin.getTotalFee());
		assertEquals(6, persistedFin.getFinanceId());
	}

	// findByPatientId	
	@Test
	void testFindByPatientId(){
		Finance fin = new Finance(6,106,"Vinay",400,30,20,490);
		
		Finance persistedFin = financeService.save(fin);
		
		assertEquals(106, persistedFin.getPatientId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(30, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(490, persistedFin.getTotalFee());
		assertEquals(6, persistedFin.getFinanceId());
	}

	// deleteFinanceByPatientId
	@Test
	void testDeleteFinanceByPatientId() {
		Finance fin = new Finance(6,106,"Vinay",400,30,20,490);
		
		Finance persistedFin = financeService.save(fin);
		
		assertEquals(106, persistedFin.getPatientId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(30, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(490, persistedFin.getTotalFee());
		assertEquals(6, persistedFin.getFinanceId());
	}

	// updateFinance
	@Test
	void testUpdateFinance() {
		Finance fin = new Finance();
		fin.setPatientId(103);
		fin.setPatientName("Krithi s");
		fin.setRegistrationFee(400);
		fin.setDoctorFee(60);
		fin.setMedicinesAmount(20);
		fin.setTotalFee(480);
		fin.setFinanceId(3);
		Finance update = financeService.updateFinance(fin);
		assertEquals(3, update.getFinanceId());
	}
	
}