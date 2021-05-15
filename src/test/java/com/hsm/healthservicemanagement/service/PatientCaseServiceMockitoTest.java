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
	
	@InjectMocks
	PatientCaseServiceImpl pService;
	
	@MockBean
	IPatientCaseRepository crepository;
	
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testSavePatientCase()
	{
		PatientCase patientcase = new PatientCase(101,"Dart","Sam",500,"11-05-2021","Headache","Medication",10);
		Mockito.when(crepository.save(patientcase)).thenReturn(patientcase);
		PatientCase persistedPt = pService.save(patientcase);
		assertEquals("Sam",persistedPt.getAssociateDoctorName());
		assertEquals(101,persistedPt.getPatientCaseId());
		assertEquals("Dart",persistedPt.getMedicines());
		assertEquals(500,persistedPt.getMedicineFee());
		assertEquals("11-05-2021",persistedPt.getAppointmentDate());
		assertEquals("Headache",persistedPt.getDiseaseDescription());
		assertEquals("Medication",persistedPt.getCurrentTreatment());
		assertEquals(10,persistedPt.getPatientId());
	}
	
	@Test
	void testViewPatientCaseById()
	{
		PatientCase patientcase = new PatientCase(102,"Dolo","Ram",400,"21-05-2021","Fever","Injectionn",11);
		Mockito.when(crepository.findById(102)).thenReturn(Optional.of(patientcase));
		PatientCase persistedPt = pService.viewPatientCaseById(102);
		assertEquals("Ram",persistedPt.getAssociateDoctorName());
		assertEquals(102,persistedPt.getPatientCaseId());
		assertEquals("Dolo",persistedPt.getMedicines());
		assertEquals(400,persistedPt.getMedicineFee());
		assertEquals("21-05-2021",persistedPt.getAppointmentDate());
		assertEquals("Fever",persistedPt.getDiseaseDescription());
		assertEquals("Injectionn",persistedPt.getCurrentTreatment());
		assertEquals(11,persistedPt.getPatientId());
		
	}
	
	@Test
	void testupdatePatientCase()
	{
		PatientCase patientcase = new PatientCase(101,"Dart","Sam",500,"11-05-2021","Headache","Medication",10);
		Mockito.when(crepository.findById(101)).thenReturn(Optional.of(patientcase));
		Mockito.when(crepository.save(patientcase)).thenReturn(patientcase);
		PatientCase persistedPt = pService.update(patientcase);
		assertEquals("Sam",persistedPt.getAssociateDoctorName());
		assertEquals(101,persistedPt.getPatientCaseId());
		assertEquals("Dart",persistedPt.getMedicines());
		assertEquals(500,persistedPt.getMedicineFee());
		assertEquals("11-05-2021",persistedPt.getAppointmentDate());
		assertEquals("Headache",persistedPt.getDiseaseDescription());
		assertEquals("Medication",persistedPt.getCurrentTreatment());
		assertEquals(10,persistedPt.getPatientId());
		
	}
	
	@Test
	void testDeletePatientCase()
	{
		PatientCase patientcase = new PatientCase(101,"Dart","Sam",500,"11-05-2021","Headache","Medication",10);
		Mockito.when(crepository.findById(101)).thenReturn(Optional.of(patientcase));
		crepository.deleteById(101);
		PatientCase persistedPt = pService.deletePatientCase(101);
		assertEquals("Sam",persistedPt.getAssociateDoctorName());
		assertEquals(101,persistedPt.getPatientCaseId());
		assertEquals("Dart",persistedPt.getMedicines());
		assertEquals(500,persistedPt.getMedicineFee());
		assertEquals("11-05-2021",persistedPt.getAppointmentDate());
		assertEquals("Headache",persistedPt.getDiseaseDescription());
		assertEquals("Medication",persistedPt.getCurrentTreatment());
		assertEquals(10,persistedPt.getPatientId());
		
	}
	
	
	@Test
	void testViewAllPatientCase()
	{
		PatientCase patientcase1 = new PatientCase(101,"Dart","Sam",500,"11-05-2021","Headache","Medication",10);
		PatientCase patientcase2 = new PatientCase(102,"Dolo","Ram",400,"21-05-2021","Fever","Injectionn",11);
		List<PatientCase> patientcaseList = new ArrayList();
		patientcaseList.add(patientcase1);
		patientcaseList.add(patientcase2);
		Mockito.when(crepository.findAll()).thenReturn(patientcaseList);
		List<PatientCase> patientcase = pService.viewAll();
		assertEquals(2,patientcase.size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
