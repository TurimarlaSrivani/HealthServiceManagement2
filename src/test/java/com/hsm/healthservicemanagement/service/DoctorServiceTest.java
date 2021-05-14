package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Doctor;

@SpringBootTest
class DoctorServiceTest {

	@Autowired
	IDoctorService doctService;
	
	@Test
	void  testFindAllDoctors() {
		List<Doctor> doctor = doctService.findAll(); 
		assertEquals(5, doctor.size());
	}
	
	@Test
	void testFindByDoctorId() {
		Doctor doctor = doctService.findByDoctId(1);
		assertEquals("priya", doctor.getUserName());
		assertEquals(8, doctor.getYearsOfExperience());
	}
	
	@Test
	void testFindByDoctorName() {
		Doctor doctor = doctService.findByDoctorName("vidya shree");
		assertEquals(2, doctor.getDoctorId());
		assertEquals("vidya", doctor.getUserName());
	}
	
	@Test
	void testFindByUserName() {
		Doctor doctor = doctService.findByUserName("deepak");
		assertEquals(3, doctor.getDoctorId());
		assertEquals(6, doctor.getHoursOfAvailability());
	}
	
	@Test
	void findByspecialization() {
		Doctor doctor = doctService.findByspecialization("oncologist");
		assertEquals(6, doctor.getHoursOfAvailability());
	}
	
	@Test
	void testFindByContactNumber() {
		Doctor doctor = doctService.findByContactNumber("9876678954");
		assertEquals(1, doctor.getDoctorId());
		assertEquals(4, doctor.getHoursOfAvailability());
	}
	
/*	@Test
	void testCreateDoctor() {
	Doctor doctor =new Doctor(7, "aishwarya", "6789487654", 10, "dentist", "mbbs", 5, 800, "aishu");
	
	List<Patient> patients = new ArrayList<Patient>();
	patients.addAll(1, patients);
	//patients.add(new Patient());
	//Patient patient = patients.get(1);
	
	//Patient[] patient = new Patient[2];
	//Patient patient = new Patient(1, "akash");
	//doctor.setPatient(patient);
	
	Doctor persisteddoct = doctService.save(doctor);
	assertEquals(7, persisteddoct.getDoctorId());
	assertEquals("aishwarya", persisteddoct.getDoctorName());
	assertEquals("6789487654", persisteddoct.getContactNumber());
	assertEquals(10, persisteddoct.getHoursOfAvailability());
	assertEquals("dentist", persisteddoct.getSpecialization());
	assertEquals("mbbs", persisteddoct.getDegree());
	assertEquals(5, persisteddoct.getYearsOfExperience());
	assertEquals(800, persisteddoct.getDoctorFee());
	assertEquals("aishu", persisteddoct.getUserName());
	
    }*/
	
/*	@Test
	void testDeleteDoctor() {
		Doctor doctor =new Doctor(7, "aishwarya", "6789487654", 10, "dentist", "mbbs", 5, 800, "aishu");	
		Doctor persisteddoct = doctService.delete(doctor);
		assertEquals(7, persisteddoct.getDoctorId());
		assertEquals("aishwarya", persisteddoct.getDoctorName());
		assertEquals("6789487654", persisteddoct.getContactNumber());
		assertEquals(10, persisteddoct.getHoursOfAvailability());
		assertEquals("dentist", persisteddoct.getSpecialization());
		assertEquals("mbbs", persisteddoct.getDegree());
		assertEquals(5, persisteddoct.getYearsOfExperience());
		assertEquals(800, persisteddoct.getDoctorFee());
		assertEquals("aishu", persisteddoct.getUserName());
	}*/
}
