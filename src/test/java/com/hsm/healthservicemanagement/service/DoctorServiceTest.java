package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Doctor;

@SpringBootTest
class DoctorServiceTest {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DoctorServiceTest.class);

	@Autowired
	IDoctorService doctService;

	// Testing whether the doctor database has doctor or null.
	// viewAllDoctorDetails
	@Test
	@Order(2)
	void testFindAllDoctors() {
		List<Doctor> doctor = doctService.findAll();
		logger.info(doctor);
		assertEquals(3, doctor.size());
	}

	// Testing whether the given id fetches the given doctor or not.
	// findBydoctorId
	@Test
	@Order(3)
	void testFindByDoctorId() {
		Doctor doctor = doctService.findByDoctId(802);
		assertEquals("abhilash", doctor.getDoctorName());
		assertEquals(2, doctor.getYearsOfExperience());
		logger.info("logger view doctor by findbydoctorId ");
	}

	// Testing whether the given name fetches the given doctor or not.
	// findbydoctName
	@Test
	@Order(4)
	void testFindByDoctorName() {
		Doctor doctor = doctService.findByDoctorName("vidya shree");
		assertEquals(801, doctor.getDoctorId());
		assertEquals("dentist", doctor.getSpecialization());
		logger.info("logger view doctor by findbydoctName ");
	}

	// Testing whether the given specialization fetches the given doctor or not.
	// findByspecialization
	@Test
	@Order(5)
	void findByspecialization() {
		Doctor doctor = doctService.findByspecialization("cardiologist");
		assertEquals(8, doctor.getHoursOfAvailability());
		logger.info("logger view doctor by findByspecialization");
	}

	// Testing whether the given FindByContactNumber fetches the given doctor or
	// not.
	// FindByContactNumber
	@Test
	@Order(6)
	void testFindByContactNumber() {
		Doctor doctor = doctService.findByContactNumber("9867785643");
		assertEquals(801, doctor.getDoctorId());
		assertEquals(5, doctor.getHoursOfAvailability());
		logger.info("logger view doctor by FindByContactNumber");
	}

	// Testing whether the doctor gets saved to the database.
	// save Doctor
	@Test
	@Order(1)
	void testCreateDoctor() {
		Doctor doctor = new Doctor(803, "aishwarya", "6789487654", 10, "oncologist", "md", 5, 800);

		Doctor persisteddoct = doctService.save(doctor);

		assertEquals(803, persisteddoct.getDoctorId());
		assertEquals("aishwarya", persisteddoct.getDoctorName());
		assertEquals("6789487654", persisteddoct.getContactNumber());
		assertEquals(10, persisteddoct.getHoursOfAvailability());
		assertEquals("oncologist", persisteddoct.getSpecialization());
		assertEquals("md", persisteddoct.getDegree());
		assertEquals(5, persisteddoct.getYearsOfExperience());
		assertEquals(800, persisteddoct.getDoctorFee());
		logger.info("logger save to Doctor");

	}

	// Testing whether the doctor gets removed from the database
	// delete doctor
	@Test
	@Order(7)
	void testDeleteDoctor() {
		Doctor doctor = new Doctor(803, "aishwarya", "6789487654", 10, "oncologist", "md", 5, 800);

		Doctor persisteddoct = doctService.delete(doctor);

		assertEquals(803, persisteddoct.getDoctorId());
		assertEquals("aishwarya", persisteddoct.getDoctorName());
		assertEquals("6789487654", persisteddoct.getContactNumber());
		assertEquals(10, persisteddoct.getHoursOfAvailability());
		assertEquals("oncologist", persisteddoct.getSpecialization());
		assertEquals("md", persisteddoct.getDegree());
		assertEquals(5, persisteddoct.getYearsOfExperience());
		assertEquals(800, persisteddoct.getDoctorFee());
		logger.info("Deleted succesfully");
	}
}
