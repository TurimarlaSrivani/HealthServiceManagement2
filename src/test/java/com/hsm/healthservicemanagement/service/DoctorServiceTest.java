package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Doctor;

@SpringBootTest
class DoctorServiceTest {

	@Autowired
	IDoctorService doctService;
	
	@Test
	@Order(2)
	void  testFindAllDoctors() {
		List<Doctor> doctor = doctService.findAll(); 
		assertEquals(2, doctor.size());
	}
	
	@Test
	@Order(3)
	void testFindByDoctorId() {
		Doctor doctor = doctService.findByDoctId(802);
		assertEquals("abhilash", doctor.getDoctorName());
		assertEquals(2, doctor.getYearsOfExperience());
	}
	
	@Test
	@Order(4)
	void testFindByDoctorName() {
		Doctor doctor = doctService.findByDoctorName("vidya shree");
		assertEquals(801, doctor.getDoctorId());
		assertEquals("dentist", doctor.getSpecialization());
	}
		
	@Test
	@Order(5)
	void findByspecialization() {
		Doctor doctor = doctService.findByspecialization("cardiologist");
		assertEquals(8, doctor.getHoursOfAvailability());
	}
	
	@Test
	@Order(6)
	void testFindByContactNumber() {
		Doctor doctor = doctService.findByContactNumber("9867785643");
		assertEquals(801, doctor.getDoctorId());
		assertEquals(5, doctor.getHoursOfAvailability());
	}
	
	@Test
	@Order(1)
	void testCreateDoctor() {
	Doctor doctor =new Doctor(803, "aishwarya", "6789487654", 10, "oncologist", "md", 5, 800);
	
	//Patient m1= new Patient (103, "2021-05-08", 22, "9243552265", "Gagana", 600, "Fever", "2021-05-08", 4, 202);
	//	Patient m2 = new Patient ();
		//List<Patient> patient =Stream.of(m1).collect(Collectors.toList());
	
	Doctor persisteddoct = doctService.save(doctor);
	assertEquals(803, persisteddoct.getDoctorId());
	assertEquals("aishwarya", persisteddoct.getDoctorName());
	assertEquals("6789487654", persisteddoct.getContactNumber());
	assertEquals(10, persisteddoct.getHoursOfAvailability());
	assertEquals("oncologist", persisteddoct.getSpecialization());
	assertEquals("md", persisteddoct.getDegree());
	assertEquals(5, persisteddoct.getYearsOfExperience());
	assertEquals(800, persisteddoct.getDoctorFee());
	
    }
	
	@Test
	@Order(7)
	void testDeleteDoctor() {
		Doctor doctor =new Doctor(803, "aishwarya", "6789487654", 10, "oncologist", "md", 5, 800);	
		Doctor persisteddoct = doctService.delete(doctor);
		assertEquals(803, persisteddoct.getDoctorId());
		assertEquals("aishwarya", persisteddoct.getDoctorName());
		assertEquals("6789487654", persisteddoct.getContactNumber());
		assertEquals(10, persisteddoct.getHoursOfAvailability());
		assertEquals("oncologist", persisteddoct.getSpecialization());
		assertEquals("md", persisteddoct.getDegree());
		assertEquals(5, persisteddoct.getYearsOfExperience());
		assertEquals(800, persisteddoct.getDoctorFee());
	}
}
