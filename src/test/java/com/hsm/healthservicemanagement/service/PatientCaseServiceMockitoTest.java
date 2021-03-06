package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.hsm.healthservicemanagement.entity.PatientCase;
import com.hsm.healthservicemanagement.repository.IPatientCaseRepository;

@ExtendWith(SpringExtension.class)
public class PatientCaseServiceMockitoTest {
	
	// Mock - imitating
		// DB
		// Products
		// @InjectMocks - injects DietService and inject dependent classes/interfaces
		// that are annotated with @Mock

	@InjectMocks
	PatientCaseServiceImpl pService;
	
	// @MockBean - injecting external services
	@MockBean
	IPatientCaseRepository crepository;
	
	// Initialisation of mock objects
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	//save
	@Test
	void testSavePatientCase()
	{
		PatientCase patientcase = new PatientCase(13,"Motrin","hari",6000,"2021-15-05","Pregnancytest","vasectomy",104);
		Mockito.when(crepository.save(patientcase)).thenReturn(patientcase);
		PatientCase persistedPt = pService.save(patientcase);
		assertEquals("hari",persistedPt.getAssociateDoctorName());
		assertEquals(13,persistedPt.getPatientCaseId());
		assertEquals("Motrin",persistedPt.getMedicines());
		assertEquals(6000,persistedPt.getMedicineFee());
		assertEquals("15-05-2021",persistedPt.getAppointmentDate());
		assertEquals("Pregnancytest",persistedPt.getDiseaseDescription());
		assertEquals("vasectomy",persistedPt.getCurrentTreatment());
		assertEquals(104,persistedPt.getPatientId());
	}
	
	//ViewPatientCaseById
	@Test
	void testViewPatientCaseById()
	{
		PatientCase patientcase = new PatientCase(10,"NSAID","harini",2000,"2021-01-05","EyeSight","Lasik",101);
		Mockito.when(crepository.findById(10)).thenReturn(Optional.of(patientcase));
		PatientCase persistedPt = pService.viewPatientCaseById(10);
		assertEquals("harini",persistedPt.getAssociateDoctorName());
		assertEquals(10,persistedPt.getPatientCaseId());
		assertEquals("NSAID",persistedPt.getMedicines());
		assertEquals(2000,persistedPt.getMedicineFee());
		assertEquals("01-05-2021",persistedPt.getAppointmentDate());
		assertEquals("Eyesight",persistedPt.getDiseaseDescription());
		assertEquals("Lasik",persistedPt.getCurrentTreatment());
		assertEquals(101,persistedPt.getPatientId());
		
	}
	
	//updatePatientCase
	@Test
	void testupdatePatientCase()
	{
		PatientCase patientcase = new PatientCase(10,"2021-01-05","harini",2000,"EyeSight","Lasik","NSAID",101);
		Mockito.when(crepository.findById(10)).thenReturn(Optional.of(patientcase));
		Mockito.when(crepository.save(patientcase)).thenReturn(patientcase);
		PatientCase persistedPt = pService.update(patientcase);
		assertEquals("Sam",persistedPt.getAssociateDoctorName());
		assertEquals(10,persistedPt.getPatientCaseId());
		assertEquals("NSAID",persistedPt.getMedicines());
		assertEquals(2000,persistedPt.getMedicineFee());
		assertEquals("2021-01-05",persistedPt.getAppointmentDate());
		assertEquals("EyeSight",persistedPt.getDiseaseDescription());
		assertEquals("Lasik",persistedPt.getCurrentTreatment());
		assertEquals(101,persistedPt.getPatientId());
		
	}
	
	//testDeletePatientCase
	@Test
	void testDeletePatientCase()
	{
		PatientCase patientcase = new PatientCase(10,"2021-01-05","harini",2000,"EyeSight","Lasik","NSAID",101);
		Mockito.when(crepository.findById(10)).thenReturn(Optional.of(patientcase));
		crepository.deleteById(10);
		PatientCase persistedPt = pService.deletePatientCase(101);
		assertEquals("krish",persistedPt.getAssociateDoctorName());
		assertEquals(10,persistedPt.getPatientCaseId());
		assertEquals("NSAID",persistedPt.getMedicines());
		assertEquals(2000,persistedPt.getMedicineFee());
		assertEquals("01-05-2021",persistedPt.getAppointmentDate());
		assertEquals("EyeSight",persistedPt.getDiseaseDescription());
		assertEquals("Lasik",persistedPt.getCurrentTreatment());
		assertEquals(101,persistedPt.getPatientId());
		
	}
	
	//testViewAllPatientCase
	@Test
	void testViewAllPatientCase()
	{
		PatientCase patientcase1 = new PatientCase(10,"2021-01-05","harini",2000,"EyeSight","Lasik","NSAID",101);
		PatientCase patientcase2 = new PatientCase(11,"2021-05-05","Pavani",7000,"Nosesurgery","rhinoplasty","Astemizole",102);
		PatientCase patientcase3 = new PatientCase(12,"2021-10-05","sravanthi",8000,"KidneyFailure","dialysis","ESRD",103);
		List<PatientCase> patientcaseList = new ArrayList();
		patientcaseList.add(patientcase1);
		patientcaseList.add(patientcase2);
		patientcaseList.add(patientcase3);
		
		Mockito.when(crepository.findAll()).thenReturn(patientcaseList);
		List<PatientCase> patientcase = pService.viewAll();
		assertEquals(3,patientcase.size());
	}
}