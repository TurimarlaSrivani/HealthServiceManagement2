package com.cg.hsm.service;

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

import com.cg.hsm.entity.Treatment;
import com.cg.hsm.entity.TreatmentStatus;
import com.cg.hsm.repository.ITreatmentRepository;
import com.cg.hsm.serviceimpl.TreatmentServiceImpl;

@ExtendWith(SpringExtension.class)
public class TreatmentServiceMockitoTests {
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

	// save
	@Test
	void testSave() {
		

		Treatment t = new Treatment(3, 103,LocalDate.of(2021, 10, 03), 5000, "vasectomy",TreatmentStatus.APPOINTED);
		Mockito.when(treatmentRepo.save(t)).thenReturn(t);

		Treatment persistedt = treatmentService.save(t);

		assertEquals(3, persistedt.getTreatmentId());
		assertEquals(103, persistedt.getPatientCaseId());
		assertEquals("vasectomy", persistedt.getCurrentTreatment());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 03), persistedt.getTreatmentDate());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
	}

	// findAllTreatmentDetails
	@Test
	void testFindAllTreatment() {
		Treatment t1 = new Treatment(1, 101,LocalDate.of(2021, 10, 02), 5000, "rhinoplasty",TreatmentStatus.APPOINTED);
		Treatment t2 = new Treatment(2, 102, LocalDate.of(2021, 10, 01), 5000, "angioplasty",TreatmentStatus.APPOINTED);
		Treatment t3 = new Treatment(3, 103, LocalDate.of(2021, 10, 03), 5000, "vasectomy",TreatmentStatus.APPOINTED);
		Treatment t4 = new Treatment(4, 104, LocalDate.of(2021, 10, 04), 5000, "tubectomy",TreatmentStatus.APPOINTED);
		Treatment t5 = new Treatment(5, 105, LocalDate.of(2021, 10, 05), 5000, "dialysis",TreatmentStatus.APPOINTED);
		Treatment t6 = new Treatment(6, 106, LocalDate.of(2021, 10, 06), 5000, "lyphoplasty",TreatmentStatus.APPOINTED);
		Treatment t7 = new Treatment(7, 107,LocalDate.of(2021, 10, 07), 5000, "rhinoplasty",TreatmentStatus.APPOINTED);
		Treatment t8 = new Treatment(8, 108, LocalDate.of(2021, 10, 8), 5000, "cataract",TreatmentStatus.APPOINTED);

		List<Treatment> treatmentList = new ArrayList<>();
		treatmentList.add(t1);
		treatmentList.add(t2);
		treatmentList.add(t3);
		treatmentList.add(t4);
		treatmentList.add(t5);
		treatmentList.add(t6);
		treatmentList.add(t7);
		treatmentList.add(t8);
		Mockito.when(treatmentRepo.findAll()).thenReturn(treatmentList);
		List<Treatment> treatment = treatmentService.findAllTreatment();
		assertEquals(8, treatment.size());
	}

	// findByTreatmentId
	@Test
	void testTreatmentById() {
		Treatment t = new Treatment(3, 103,LocalDate.of(2021, 10, 03), 5000, "vasectomy",TreatmentStatus.APPOINTED);

		Mockito.when(treatmentRepo.findById(3)).thenReturn(Optional.of(t));

		Treatment persistedt = treatmentService.findByTreatmentId(3);

		assertEquals(3, persistedt.getTreatmentId());
		assertEquals(103, persistedt.getPatientCaseId());
		assertEquals(LocalDate.of(2021, 10, 03), persistedt.getTreatmentDate());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals("vasectomy", persistedt.getCurrentTreatment());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
		
		
	}

	// update
	@Test
	void update() {
		Treatment t = new Treatment(1, 101, LocalDate.of(2021, 10, 02), 5000, "rhinoplasty",TreatmentStatus.APPOINTED);

		Mockito.when(treatmentRepo.findById(1)).thenReturn(Optional.of(t));
		Mockito.when(treatmentRepo.save(t)).thenReturn(t);

		Treatment persistedt = treatmentService.updateTreatment(t);

		assertEquals(1, persistedt.getTreatmentId());
		assertEquals(101, persistedt.getPatientCaseId());
		assertEquals(LocalDate.of(2021, 10, 02), persistedt.getTreatmentDate());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals("rhinoplasty", persistedt.getCurrentTreatment());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
		
		
	}

	// deleteTreatmentByPatientId
	@Test
	void deleteTreatmentByTreatmentId() {
		Treatment t = new Treatment(3, 103,LocalDate.of(2021, 10, 03), 5000, "vasectomy",TreatmentStatus.APPOINTED);

		Mockito.when(treatmentRepo.findById(3)).thenReturn(Optional.of(t));
		treatmentRepo.deleteById(3);

		Treatment persistedt = treatmentService.deleteTreatmentByTreatmentId(3);

		assertEquals(3, persistedt.getTreatmentId());
		assertEquals(103, persistedt.getPatientCaseId());
		assertEquals("vasectomy", persistedt.getCurrentTreatment());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 03), persistedt.getTreatmentDate());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
	}

}
