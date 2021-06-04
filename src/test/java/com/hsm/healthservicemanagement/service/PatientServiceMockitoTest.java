package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hsm.healthservicemanagement.entity.Address;
import com.hsm.healthservicemanagement.entity.Patient;
import com.hsm.healthservicemanagement.repository.IPatientRepository;

@ExtendWith(SpringExtension.class)
class PatientServiceMockitoTest {

	// @InjectMock - injects PatientService and inject dependent classes/interfaces
	// that are annotated with @Mock
	@InjectMocks
	PatientServiceImpl patientService;

	// @MockBean - injecting external services

	@MockBean
	IPatientRepository patientRepo;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	// Testing whether the patient gets created/saved .
	// createPatient
	@Test
	void testCreateEmployee() {
		Patient patient = new Patient(111, "Janu", 25, 400, "9101135666", "Nausea", LocalDate.parse("2021-05-01"),
				LocalDate.parse("2021-05-03"));
		Address address = new Address("MG Road", "Bangalore");
		patient.setAddress(address);

		Mockito.when(patientRepo.save(patient)).thenReturn(patient);

		Patient persistedPatient = patientRepo.save(patient);
		assertEquals(111, persistedPatient.getPatientId());
		assertEquals("Janu", persistedPatient.getPatientName());
		assertEquals(25, persistedPatient.getPatientAge());
		assertEquals(400, persistedPatient.getRegistrationFee());
		assertEquals("9101135666", persistedPatient.getPatientContactNumber());
		assertEquals("Nausea", persistedPatient.getSymptoms());
		assertEquals(LocalDate.parse("2021-05-01"), persistedPatient.getCreatedAt());
		assertEquals(LocalDate.parse("2021-05-03"), persistedPatient.getUpdatedAt());
	}

	// Testing whether the given id fetches the given patient or not.
	// findByPatientId
	@Test
	void testPatientById() {
		Patient patient = new Patient(105, "Roopa", 23, 500, "9241135114", "Fatigue", LocalDate.parse("2021-05-07"),
				LocalDate.parse("2021-05-10"));
		Address address = new Address("HP Nagar", "Kolar");
		patient.setAddress(address);

		Mockito.when(patientRepo.findById(105)).thenReturn(Optional.of(patient));

		Patient persistedPatient = patientService.findByPatientId(105);
		assertEquals(105, persistedPatient.getPatientId());
		assertEquals("Roopa", persistedPatient.getPatientName());
		assertEquals(23, persistedPatient.getPatientAge());
		assertEquals(500, persistedPatient.getRegistrationFee());
		assertEquals("9241135114", persistedPatient.getPatientContactNumber());
		assertEquals("Fatigue", persistedPatient.getSymptoms());
		assertEquals(LocalDate.parse("2021-05-07"), persistedPatient.getCreatedAt());
		assertEquals(LocalDate.parse("2021-05-10"), persistedPatient.getUpdatedAt());
	}

	// Testing whether all patient are present or null.
	// findAll
	@Test
	void testAllPatients() {
		Patient patient1 = new Patient(111, "Janu", 25, 400, "9101135666", "Nausea", LocalDate.parse("2021-05-01"),
				LocalDate.parse("2021-05-03"));
		Patient patient2 = new Patient(105, "Roopa", 23, 500, "9241135114", "Fatigue", LocalDate.parse("2021-05-07"),
				LocalDate.parse("2021-05-10"));

		List<Patient> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);

		Mockito.when(patientRepo.findAll()).thenReturn(patientList);

		List<Patient> patients = patientService.findAll();

		assertEquals(2, patients.size());

	}

	// Testing whether the given id updates the given patient or not.
	// updateByPatientId
	@Test
	void testupdateByPatientId() {
		Patient patient = new Patient(105, "Ram", 23, 500, "9241135114", "Fatigue", LocalDate.parse("2021-05-07"),
				LocalDate.parse("2021-05-10"));
		Address address = new Address("HP Nagar", "Kolar");
		patient.setAddress(address);

		Mockito.when(patientRepo.findById(105)).thenReturn(Optional.of(patient));
		Mockito.when(patientRepo.save(patient)).thenReturn(patient);

		Patient persistedPatient = patientService.updateByPatientId(105);
		assertEquals(105, persistedPatient.getPatientId());
		assertEquals("Ram", persistedPatient.getPatientName());
		assertEquals(23, persistedPatient.getPatientAge());
		assertEquals(500, persistedPatient.getRegistrationFee());
		assertEquals("9241135114", persistedPatient.getPatientContactNumber());
		assertEquals("Fatigue", persistedPatient.getSymptoms());
		assertEquals(LocalDate.parse("2021-05-07"), persistedPatient.getCreatedAt());
		assertEquals(LocalDate.parse("2021-05-10"), persistedPatient.getUpdatedAt());
	}

	// Testing whether the patient gets deleted.
	// deletePatientById
	@Test
	void testdeleteByPatientId() {
		Patient patient = new Patient(105, "Ram", 23, 500, "9241135114", "Fatigue", LocalDate.parse("2021-05-07"),
				LocalDate.parse("2021-05-10"));
		Address address = new Address("HP Nagar", "Kolar");
		patient.setAddress(address);

		Mockito.when(patientRepo.findById(105)).thenReturn(Optional.of(patient));
		patientRepo.deleteById(105);

		Patient persistedPatient = patientService.deleteByPatientId(105);
		assertEquals(105, persistedPatient.getPatientId());
		assertEquals("Ram", persistedPatient.getPatientName());
		assertEquals(23, persistedPatient.getPatientAge());
		assertEquals(500, persistedPatient.getRegistrationFee());
		assertEquals("9241135114", persistedPatient.getPatientContactNumber());
		assertEquals("Fatigue", persistedPatient.getSymptoms());
		assertEquals(LocalDate.parse("2021-05-07"), persistedPatient.getCreatedAt());
		assertEquals(LocalDate.parse("2021-05-10"), persistedPatient.getUpdatedAt());
	}

}