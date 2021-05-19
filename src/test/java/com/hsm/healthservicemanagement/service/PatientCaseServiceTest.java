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
	
	
	//viewall patientcase
	@Test
	void testviewAllPatientCase()
	{
		List<PatientCase> patientcase = pcService.viewAll();
		assertEquals(3,patientcase.size());
	}
	
	//viewpatientcasebyId
	@Test
	void testviewPatientCaseById()
	{
		PatientCase pa = pcService.viewPatientCaseById(10);
		assertEquals("harini",pa.getAssociateDoctorName());
		assertEquals(10,pa.getPatientCaseId());
		assertEquals("NSAID",pa.getMedicines());
		assertEquals(2000,pa.getMedicineFee());
		assertEquals("2021-01-05",pa.getAppointmentDate());
		assertEquals("EyeSight",pa.getDiseaseDescription());
		assertEquals("Lasik",pa.getCurrentTreatment());
		assertEquals(101,pa.getPatientId());
	}
	
	//savepatientcase
	@Test
	void testSavePatientCase()
	{
		PatientCase patientcase = new PatientCase(13,"Motrin","hari",6000,"2021-15-05","Pregnancytest","vasectomy",104);
		PatientCase persistedPt = pcService.save(patientcase);
		assertEquals("hari",persistedPt.getAssociateDoctorName());
		assertEquals(13,persistedPt.getPatientCaseId());
		assertEquals("Motrin",persistedPt.getMedicines());
		assertEquals(6000,persistedPt.getMedicineFee());
		assertEquals("2021-15-05",persistedPt.getAppointmentDate());
		assertEquals("Pregnancytest",persistedPt.getDiseaseDescription());
		assertEquals("vasectomy",persistedPt.getCurrentTreatment());
		assertEquals(104,persistedPt.getPatientId());
	}
	
	//deletepatientcase
	@Test
	void testDeletePatientCase()
	{
		PatientCase patientcase = new PatientCase(13,"Motrin","hari",6000,"2021-15-05","Pregnancytest","vasectomy",104);
		PatientCase persistedPt = pcService.deletePatientCase(13);
		assertEquals("hari",persistedPt.getAssociateDoctorName());
		assertEquals(13,persistedPt.getPatientCaseId());
		assertEquals("Motrin",persistedPt.getMedicines());
		assertEquals(6000,persistedPt.getMedicineFee());
		assertEquals("2021-15-05",persistedPt.getAppointmentDate());
		assertEquals("Pregnancytest",persistedPt.getDiseaseDescription());
		assertEquals("vasectomy",persistedPt.getCurrentTreatment());
		assertEquals(104,persistedPt.getPatientId());
	}
	
	//update patientcase
	@Test
	public void updatePatientCase()
	{
		PatientCase p = new PatientCase();
		p.setPatientCaseId(10);
		p.setAppointmentDate("2021-01-05");
		p.setAssociateDoctorName("Rashmi");
		p.setCurrentTreatment("Lasik");
		p.setDiseaseDescription("EyeSight");
		p.setMedicineFee(2000);
		p.setMedicines("NSAID");
		p.setPatientId(101);
	}
	
}