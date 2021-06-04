package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Address;
import com.hsm.healthservicemanagement.entity.Patient;

@SpringBootTest
class PatientServiceTest {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PatientServiceTest.class);

	@Autowired
	IPatientService patientService;

	// Testing whether the patient gets created/saved to the database.
	// createPatient
	@Order(1)
	@Test
	void testCreatePatient() {
		Patient patient = new Patient(106, "Yashu", 22, 400, "9101135114", "BodyPain", LocalDate.parse("2021-05-14"),
				LocalDate.parse("2021-05-14"));
		Address address = new Address("MG Road", "Hyderabad");
		patient.setAddress(address);
		Patient persistedPatient = patientService.save(patient);
		assertEquals(106, persistedPatient.getPatientId());
		assertEquals("Yashu", persistedPatient.getPatientName());
		assertEquals(22, persistedPatient.getPatientAge());
		assertEquals(400, persistedPatient.getRegistrationFee());
		assertEquals("9101135114", persistedPatient.getPatientContactNumber());
		assertEquals("BodyPain", persistedPatient.getSymptoms());
		assertEquals(LocalDate.parse("2021-05-14"), persistedPatient.getCreatedAt());
		assertEquals(LocalDate.parse("2021-05-14"), persistedPatient.getUpdatedAt());
		logger.info("logger save to Patient");
	}

	// Testing whether the given id fetches the given patient or not.
	// findByPatientId
	@Order(2)
	@Test
	void testfindByPatientId() {
		Patient patient = patientService.findByPatientId(103);
		assertEquals("Krithi", patient.getPatientName());
		logger.info("logger find patient by findByPatientId ");
	}

	// Testing whether the given name fetches the given patient or not.
	// findPatientByName
	@Order(3)
	@Test
	void testfindByPatientName() {
		Patient patient = patientService.findByPatientName("Sam");
		assertEquals("Sam", patient.getPatientName());
		assertEquals("Cold", patient.getSymptoms());
		logger.info("logger find patient by findByPatientName ");
	}

	// Testing whether the patient database has patient or null.
	// findAll
	@Order(4)
	@Test
	void testFindAllPatients() {
		List<Patient> patients = patientService.findAll();
		assertEquals(6, patients.size());
		logger.info("logger added to findAll");
	}

	// Testing whether the patient gets deleted from the database
	// deletePatient
	@Order(5)
	@Test
	void testDeletePatient() {
		Patient patient = new Patient(106, "Yashu", 22, 400, "9101135114", "BodyPain", LocalDate.parse("2021-05-14"),
				LocalDate.parse("2021-05-14"));
		Address address = new Address("MG Road", "Hyderabad");
		patient.setAddress(address);
		Patient persistedPatient = patientService.save(patient);
		assertEquals(106, persistedPatient.getPatientId());
		assertEquals("Yashu", persistedPatient.getPatientName());
		assertEquals(22, persistedPatient.getPatientAge());
		assertEquals(400, persistedPatient.getRegistrationFee());
		assertEquals("9101135114", persistedPatient.getPatientContactNumber());
		assertEquals("BodyPain", persistedPatient.getSymptoms());
		assertEquals(LocalDate.parse("2021-05-14"), persistedPatient.getCreatedAt());
		assertEquals(LocalDate.parse("2021-05-14"), persistedPatient.getUpdatedAt());
		logger.info("logger delete patient by patientId");
	}
}