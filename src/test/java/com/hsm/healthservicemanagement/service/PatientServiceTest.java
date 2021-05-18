package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Address;
import com.hsm.healthservicemanagement.entity.Patient;

@SpringBootTest
class PatientServiceTest {

	@Autowired
	IPatientService patientService;

	// findByPatientId
	@Order(2)
	@Test
	void testfindByPatientId() {
		Patient patient = patientService.findByPatientId(103);
		assertEquals("Krithi", patient.getPatientName());
	}

	// findPatientByName
	@Order(3)
	@Test
	void testfindByPatientName() {
		Patient patient = patientService.findByPatientName("Sam");
		assertEquals("Sam", patient.getPatientName());
		assertEquals("Cold", patient.getSymptoms());
	}

	// findAll
	@Order(4)
	@Test
	void testFindAllPatients() {
		List<Patient> patients = patientService.findAll();
		assertEquals(6, patients.size());
	}
	
	// createPatient
	@Test
	@Order(1)
	void testCreatePatient() {
		Patient patient = new Patient(106, "Yashu",22, 400, "9101135114", "BodyPain", LocalDate.parse("2021-05-14"),
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

	}

	// deletePatient
	@Order(5)
	@Test
	void testDeletePatient() {
		Patient patient = new Patient(106, "Yashu",22, 400, "9101135114", "BodyPain", LocalDate.parse("2021-05-14"),
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

	}
}