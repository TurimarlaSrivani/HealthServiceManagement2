package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.PatientCase;



@SpringBootTest
public class PatientCaseServiceTest {
	
	@Autowired
	IPatientCaseService pcService;
	
	@Test
	void testviewAllPatientCase()
	{
		List<PatientCase> patientcase = pcService.viewAll();
		assertEquals(2,patientcase.size());
	}
	
	@Test
	void testviewPatientCaseById()
	{
		PatientCase pa = pcService.viewPatientCaseById(102);
		assertEquals("Ram",pa.getAssociateDoctorName());
		assertEquals(102,pa.getPatientCaseId());
		assertEquals("Dolo",pa.getMedicines());
		assertEquals(400,pa.getMedicineFee());
		assertEquals("21-05-2021",pa.getAppointmentDate());
		assertEquals("Fever",pa.getDiseaseDescription());
		assertEquals("injectionn",pa.getCurrentTreatment());
		assertEquals(11,pa.getPatientId());
	}
	
	
	@Test
	void testSavePatientCase()
	{
		PatientCase patientcase = new PatientCase(101,"Dart","Sam",500,"11-05-2021","Headache","Medication",10);
		PatientCase persistedPt = pcService.save(patientcase);
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
		PatientCase patientcase = new PatientCase(101, "Dart","Sam",500,"11-05-2021","Headache","Medication",10);
		PatientCase persistedPt = pcService.deletePatientCase(101);
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
	public void updatePatientCase()
	{
		PatientCase p = new PatientCase();
		p.setPatientCaseId(101);
		p.setAppointmentDate("11-05-2021");
		p.setAssociateDoctorName("Sam");
		p.setCurrentTreatment("Medication");
		p.setDiseaseDescription("Fever");
		p.setMedicineFee(500);
		p.setMedicines("Dart");
		p.setPatientId(10);
	}
	
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


