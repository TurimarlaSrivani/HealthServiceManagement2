package com.hsm.healthservicemanagement.service;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Treatment;
import com.hsm.healthservicemanagement.entity.TreatmentStatus;

@SpringBootTest
class TreatmentServiceTests {

	@Autowired
	ITreatmentService treatmentService;

	// save
	@Test
	public void testSave() {
		
		
		/* Treatment t1 = new Treatment(1,101,"2021-10-02",5000,"angioplasty");
		Treatment t2 = new Treatment(2,102,"2021-10-01",50000,"rhinoplasty");
		Treatment t3 = new Treatment(3,103,"2021-10-03",5000,"vasectomy");
		Treatment t4 = new Treatment(4,104,"2021-10-04",5000,"tubectomy");
		Treatment t5 = new Treatment(5,105,"2021-10-05",10000,"dialysis");
		Treatment t6 = new Treatment(6,106,"2021-10-06",15000,"appendectomy");
		Treatment t7 = new Treatment(7,107,"2021-10-06",5000,"cataract");
		Treatment t8 = new Treatment(8,108,"2021-10-07",5000,"rhinoplasty");  */

		Treatment t = new Treatment(8,108,LocalDate.of(2021, 10, 03),5000,"rhinoplasty",TreatmentStatus.APPOINTED);
		Treatment persistedt = treatmentService.save(t);

		assertEquals(8, persistedt.getTreatmentId());
		assertEquals(108, persistedt.getPatientCaseId());
		assertEquals("rhinoplasty", persistedt.getCurrentTreatment());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 03), persistedt.getTreatmentDate());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
	}

	// findAlltreatmentDetails
	@Test
	public void testfindAllTreatment() {
		List<Treatment> t = treatmentService.findAllTreatment();
		assertEquals(7, t.size());
	}

	// findByTreatmentId
	@Test
	public void testfindByTreatmentId() {
		Treatment t = treatmentService.findByTreatmentId(1);
		assertEquals("Lasik", t.getCurrentTreatment());
	}
	
    //findByTreatmentDate
	@Test
	public void testfindByTreatmentDate() {
		List<Treatment> t=treatmentService.findByTreatmentDate(LocalDate.of(2021, 10, 05));
		assertThat(treatmentService.findByTreatmentDate(LocalDate.of(2021, 10, 05)),hasItem(hasProperty("treatmentDate", is(LocalDate.of(2021, 10, 05)))));
	} 

	// deleteTreatmentByTreatmentId
	@Test
	public void testdeleteTreatmentByTreatmentId() {
	Treatment t = new Treatment(8,108,LocalDate.of(2021, 10, 03),5000,"rhinoplasty",TreatmentStatus.APPOINTED);
	Treatment persistedt = treatmentService.deleteTreatmentByTreatmentId(8);

	assertEquals(8, persistedt.getTreatmentId());
	assertEquals(108, persistedt.getPatientCaseId());
	assertEquals("rhinoplasty", persistedt.getCurrentTreatment());
	assertEquals(5000, persistedt.getTreatmentFee());
	assertEquals(LocalDate.of(2021, 10, 03), persistedt.getTreatmentDate());
	assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
	}

	// update
	@Test
	public void testUpdateTreatment() {
		Treatment t = new Treatment();
		t.setTreatmentId(1);
		t.setCurrentTreatment("Lasik");
		t.setPatientCaseId(101);
		t.setTreatmentDate(LocalDate.of(2021, 10, 03));
		t.setTreatmentFee(5000);
		Treatment updTreatment = treatmentService.updateTreatment(t);
		assertEquals("Lasik", updTreatment.getCurrentTreatment());
		assertEquals(101, updTreatment.getPatientCaseId());
		assertEquals(5000, updTreatment.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 03), updTreatment.getTreatmentDate());
	}
	
	//updateTreatmentDate
	@Test
	public void testUpdateTreatmentDateByTreatmentId() {
		Treatment t = new Treatment();
		t.setTreatmentId(1);
		t.setTreatmentDate(LocalDate.of(2021, 10, 03));
		
		Treatment updTreatment = treatmentService.updateTreatmentDateByTreatmentId(1,t);
		assertEquals(LocalDate.of(2021, 10, 03), updTreatment.getTreatmentDate());
	}
	
}
