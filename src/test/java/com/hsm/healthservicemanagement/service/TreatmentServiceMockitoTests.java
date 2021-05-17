package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.hsm.healthservicemanagement.entity.Treatment;
import com.hsm.healthservicemanagement.entity.TreatmentStatus;
import com.hsm.healthservicemanagement.repository.ITreatmentRepository;



@ExtendWith(SpringExtension.class)
 class TreatmentServiceMockitoTests {
	// Mock - imitating
	// DB -
	// Product -

	// @InjectMock - injects TreatmentService and inject dependent
	// classes/interfaces
	// that are annotated with @Mock
	@InjectMocks
	TreatmentServiceImpl treatmentService;

	// @MockBean - injecting external services

	@MockBean
	ITreatmentRepository treatmentRepo;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	// findAllTreatmentDetails
		@Test
		void testFindAllTreatment() {
			Treatment t1 = new Treatment(1, "rhinoplasty", 5000, LocalDate.of(2021, 10, 02),TreatmentStatus.APPOINTED);
			Treatment t2 = new Treatment(2, "angioplasty", 5000, LocalDate.of(2021, 10, 01),TreatmentStatus.APPOINTED);
			Treatment t3 = new Treatment(3, "vasectomy", 5000, LocalDate.of(2021, 10, 03),TreatmentStatus.APPOINTED);
			Treatment t4 = new Treatment(4, "tubectomy", 5000, LocalDate.of(2021, 10, 04),TreatmentStatus.APPOINTED);
			Treatment t5 = new Treatment(5, "dialysis", 5000, LocalDate.of(2021, 10, 05),TreatmentStatus.APPOINTED);
			Treatment t6 = new Treatment(6, "lyphoplasty", 5000, LocalDate.of(2021, 10, 06),TreatmentStatus.APPOINTED);
			Treatment t7 = new Treatment(7, "rhinoplasty", 5000, LocalDate.of(2021, 10, 07),TreatmentStatus.APPOINTED);

			List<Treatment> treatmentList = new ArrayList<>();
			treatmentList.add(t1);
			treatmentList.add(t2);
			treatmentList.add(t3);
			treatmentList.add(t4);
			treatmentList.add(t5);
			treatmentList.add(t6);
			treatmentList.add(t7);
			Mockito.when(treatmentRepo.findAll()).thenReturn(treatmentList);
			List<Treatment> treatment = treatmentService.findAllTreatment();
			assertEquals(7, treatment.size());
		}

	// save
	@Test
	void testSave() {
		

		Treatment t = new Treatment(8, "cataract", 5000, LocalDate.of(2021, 10, 8),TreatmentStatus.APPOINTED);
		Mockito.when(treatmentRepo.save(t)).thenReturn(t);

		Treatment persistedt = treatmentService.save(t);

		assertEquals(8, persistedt.getTreatmentId());
		assertEquals("cataract", persistedt.getCurrentTreatment());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 8), persistedt.getTreatmentDate());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
	}

	
/*	// findByTreatmentId
	@Test
	void testFindByTreatmentId() {
		Treatment t = new Treatment(8, LocalDate.of(2021, 10, 8), 5000, "cataract",TreatmentStatus.APPOINTED);
		Mockito.when(treatmentRepo.findById(8)).thenReturn(Optional.of(t));

		Treatment persistedt = treatmentService.findByTreatmentId(8);

		assertEquals(8, persistedt.getTreatmentId());
		assertEquals("cataract", persistedt.getCurrentTreatment());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 8), persistedt.getTreatmentDate());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
		
		
	}

	// update
	@Test
	void update() {
		Treatment t = new Treatment(1, LocalDate.of(2021, 10, 02), 5000, "rhinoplasty",TreatmentStatus.APPOINTED);

		Mockito.when(treatmentRepo.findById(1)).thenReturn(Optional.of(t));
		Mockito.when(treatmentRepo.save(t)).thenReturn(t);

		Treatment persistedt = treatmentService.updateTreatment(t);

		assertEquals(1, persistedt.getTreatmentId());
		assertEquals(LocalDate.of(2021, 10, 02), persistedt.getTreatmentDate());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals("rhinoplasty", persistedt.getCurrentTreatment());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
			
	} */

	// deleteTreatmentByPatientId
	@Test
	void deleteTreatmentByTreatmentId() {
		Treatment t = new Treatment(8, "cataract", 5000, LocalDate.of(2021, 10, 8),TreatmentStatus.APPOINTED);

		Mockito.when(treatmentRepo.findById(8)).thenReturn(Optional.of(t));
		treatmentRepo.deleteById(3);

		Treatment persistedt = treatmentService.deleteTreatmentByTreatmentId(8);

		assertEquals(8, persistedt.getTreatmentId());
		assertEquals("cataract", persistedt.getCurrentTreatment());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 8), persistedt.getTreatmentDate());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
	}

}
