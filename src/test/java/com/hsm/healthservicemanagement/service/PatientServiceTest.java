package com.hsm.healthservicemanagement.service;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hsm.healthservicemanagement.entity.Address;
import com.hsm.healthservicemanagement.entity.Patient;

import org.junit.jupiter.api.Test;

@SpringBootTest
class PatientServiceTest {

	@Autowired
	IPatientService patientService;

	//findAll
	@Test
	void testFindAllPatients() {
		List<Patient> patients = patientService.findAll();
		assertEquals(7, patients.size());
	}
	
    //findByPatientId
	@Test
	void findByPatientId() {
		Patient patient = patientService.findByPatientId(103);
		assertEquals("Krithi", patient.getPatientName());
	}
	
    //findPatientByName
	@Test
	void findByPatientName() {
		Patient patient = patientService.findByPatientName("Sam");
		assertEquals("Sam", patient.getPatientName());
		assertEquals("Cold", patient.getSymptoms());
	}
	
	//createPatient
	@Test
	void testCreatePatient() {
		Patient patient = new Patient(107, "Manu", 25, 400, "9101135114", "BodyPain", LocalDate.parse("2021-05-05"),
				LocalDate.parse("2021-05-09"));
		Address address = new Address("MG Road", "Hyderabad");
		patient.setAddress(address);
		Patient persistedPatient = patientService.save(patient);
		assertEquals(107, persistedPatient.getPatientId());
		assertEquals("Manu", persistedPatient.getPatientName());
		assertEquals(25, persistedPatient.getPatientAge());
		assertEquals(400, persistedPatient.getRegistrationFee());
		assertEquals("9101135114", persistedPatient.getPatientContactNumber());
		assertEquals("BodyPain", persistedPatient.getSymptoms());
		assertEquals(LocalDate.parse("2021-05-05"), persistedPatient.getCreatedAt());
		assertEquals(LocalDate.parse("2021-05-09"), persistedPatient.getUpdatedAt());

	}
	
	//deletePatient
	@Test
	void testDeletePatient() {
		Patient patient = new Patient(106, "Abi", 28, 700, "8254252566", "Cough", LocalDate.parse("2021-05-01"),
				LocalDate.parse("2021-05-03"));
		Address address = new Address("T Nagar", "Chennai");
		patient.setAddress(address);
		Patient persistedPatient = patientService.delete(patient);
		assertEquals(106, persistedPatient.getPatientId());
		assertEquals("Abi", persistedPatient.getPatientName());
		assertEquals(28, persistedPatient.getPatientAge());
		assertEquals(700, persistedPatient.getRegistrationFee());
		assertEquals("8254252566" , persistedPatient.getPatientContactNumber());
		assertEquals("Cough", persistedPatient.getSymptoms());
		assertEquals(LocalDate.parse("2021-05-01"), persistedPatient.getCreatedAt());
		assertEquals(LocalDate.parse("2021-05-03"), persistedPatient.getUpdatedAt());

	}
}