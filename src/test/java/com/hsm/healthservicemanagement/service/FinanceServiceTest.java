package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Finance;

@SpringBootTest
class FinanceServiceTest {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(FinanceServiceTest.class);

	@Autowired
	IFinanceService financeService;

	// Testing whether the diet database has diet or null.
	// findAllFinanceDetails
	@Test
	void testFindAllFinanceDetails() {
		List<Finance> fin = financeService.findAllFinanceDetails();
		logger.info(fin);
		logger.info("All Finance Details shown sucessfully");
		assertEquals(6, fin.size());
	}

	// Testing whether the finance details saves in the database.
	// save
	@Test
	void testSave() {
		Finance fin = new Finance(6, "Vinay", 400, 30, 20, 490);

		Finance persistedFin = financeService.save(fin);

		assertEquals(6, persistedFin.getFinanceId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(30, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(490, persistedFin.getTotalFee());
		logger.info("Finance Details saved successfully");

	}

	// Testing whether the given id fetches the given fiance detail or not.
	// findByPatientId
	@Test
	void testFindByFinanceId() {
		Finance fin = new Finance(6, "Vinay", 400, 30, 20, 490);

		Finance persistedFin = financeService.save(fin);

		assertEquals(6, persistedFin.getFinanceId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(30, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(490, persistedFin.getTotalFee());
		logger.info("Found FinanceId sucessfully ");

	}

	// Testing whether finance gets removed from the database
	// deleteFinanceByFinanceId
	@Test
	void testDeleteFinanceByFinanceId() {
		Finance fin = new Finance(6, "Vinay", 400, 30, 20, 490);

		Finance persistedFin = financeService.save(fin);
		assertEquals(6, persistedFin.getFinanceId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(30, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(490, persistedFin.getTotalFee());
		logger.info("Deleted succesfully");

	}

	// Testing whether the diet gets updated to the database.
	// updateFinance
	@Test
	void testUpdateFinance() {
		Finance fin = new Finance(3, "Krithi", 400, 60, 20, 480);
		fin.setFinanceId(3);
		fin.setPatientName("Krithi");
		fin.setRegistrationFee(400);
		fin.setDoctorFee(60);
		fin.setMedicinesAmount(20);
		fin.setTotalFee(480);

		Finance update = financeService.updateFinance(fin);
		assertEquals(3, update.getFinanceId());
		logger.info("Updated succesfully");
	}

}