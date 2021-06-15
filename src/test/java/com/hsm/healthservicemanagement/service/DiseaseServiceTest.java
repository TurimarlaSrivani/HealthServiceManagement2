package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Disease;

@SpringBootTest
class DiseaseServiceTest {
	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DiseaseServiceTest.class);

	@Autowired
	IDiseaseService diseaseService;

	// Testing whether disease database has disease or null
	@Test
	@Order(2)
	void testFindAllDisease() {
		List<Disease> diseases = diseaseService.findAll();
		assertEquals(7, diseases.size());
		//logger.info(diseases);
		logger.info("logger added to FindAllDisease");
	}

	// Testing whether the disease is found by using disease id in database
	@Test
	@Order(3)
	void testFindDiseaseById() {
		Disease disease = diseaseService.findByDiseaseId(901);
		assertEquals("Diabetes", disease.getDiseaseName());
		logger.info("logger view disease by FindDiseaseById ");

	}

	// Testing whether the disease gets updated in the database
	// findDiseaseByName
	@Test
	@Order(4)
	void testFindDiseaseByName() {
		Disease disease = diseaseService.findByDiseaseName("Alzeihmers");
		assertEquals(903, disease.getDiseaseId());
		assertEquals("Alzeihmers", disease.getDiseaseName());
		assertEquals("Memoryloss", disease.getDiseaseSymptoms());
		assertEquals("Deficiency", disease.getDiseaseType());
		logger.info("logger view disease by FindDiseaseByName ");

	}

	// Testing whether the disease gets created at the database
	@Test
	@Order(1)
	void testCreateDisease() {
		Disease disease = new Disease(904, "Kidney disease", "Deficiency", "Swollen limbs");

		Disease persistedDisease = diseaseService.save(disease);
		assertEquals(904, persistedDisease.getDiseaseId());
		assertEquals("Kidney disease", persistedDisease.getDiseaseName());
		assertEquals("Deficiency", persistedDisease.getDiseaseType());
		assertEquals("Swollen limbs", persistedDisease.getDiseaseSymptoms());
		logger.info("Logger save to Disease");
	}

	// Testing whether the disease detail gets removed from the database
	@Test
	@Order(5)
	void testDisease() {
		Disease disease = new Disease(904, "Kidney disease", "Deficiency", "Swollen limbs");

		Disease persistedDisease = diseaseService.save(disease);
		assertEquals(904, persistedDisease.getDiseaseId());
		assertEquals("Kidney disease", persistedDisease.getDiseaseName());
		assertEquals("Deficiency", persistedDisease.getDiseaseType());
		assertEquals("Swollen limbs", persistedDisease.getDiseaseSymptoms());
		logger.info("Deleted succesfully");

	}

}