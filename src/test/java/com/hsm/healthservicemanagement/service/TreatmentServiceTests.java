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
	 void testSave() {
		Treatment t = new Treatment(8,"rhinoplasty",5000,LocalDate.of(2021, 10, 03),TreatmentStatus.APPOINTED);
		Treatment persistedt = treatmentService.save(t);

		assertEquals(8, persistedt.getTreatmentId());
		assertEquals("rhinoplasty", persistedt.getCurrentTreatment());
		assertEquals(5000, persistedt.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 03), persistedt.getTreatmentDate());
		assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
	}

	// findAlltreatmentDetails
	@Test
	 void testfindAllTreatment() {
		List<Treatment> t = treatmentService.findAllTreatment();
		assertEquals(7, t.size());
	}

	// findByTreatmentId
	@Test
	 void testfindByTreatmentId() {
		Treatment t = treatmentService.findByTreatmentId(1);
		assertEquals("Lasik", t.getCurrentTreatment());
	}
	
    //findByTreatmentDate
	@Test
	 void testfindByTreatmentDate() {
		List<Treatment> t=treatmentService.findByTreatmentDate(LocalDate.of(2021, 10, 05));
		assertThat(treatmentService.findByTreatmentDate(LocalDate.of(2021, 10, 05)),hasItem(hasProperty("treatmentDate", is(LocalDate.of(2021, 10, 05)))));
	} 

	// deleteTreatmentByTreatmentId
	@Test
	 void testdeleteTreatmentByTreatmentId() {

	Treatment t = new Treatment(8,"rhinoplasty",5000,LocalDate.of(2021, 10, 03),TreatmentStatus.APPOINTED);

	Treatment persistedt = treatmentService.deleteTreatmentByTreatmentId(8);

	assertEquals(8, persistedt.getTreatmentId());
	assertEquals("rhinoplasty", persistedt.getCurrentTreatment());
	assertEquals(5000, persistedt.getTreatmentFee());
	assertEquals(LocalDate.of(2021, 10, 03), persistedt.getTreatmentDate());
	assertEquals(TreatmentStatus.APPOINTED, persistedt.getTreatmentStatus());
	}

	// update
	@Test
	 void testUpdateTreatment() {
		Treatment t = new Treatment();
		t.setTreatmentId(1);
		t.setCurrentTreatment("Lasik");
		t.setTreatmentDate(LocalDate.of(2021, 10, 03));
		t.setTreatmentFee(5000);
		Treatment updTreatment = treatmentService.updateTreatment(t);
		assertEquals("Lasik", updTreatment.getCurrentTreatment());
		assertEquals(5000, updTreatment.getTreatmentFee());
		assertEquals(LocalDate.of(2021, 10, 03), updTreatment.getTreatmentDate());
	}
	
	//updateTreatmentDate
	@Test
	 void testUpdateTreatmentDateByTreatmentId() {
		Treatment t = new Treatment();
		t.setTreatmentId(1);
		t.setTreatmentDate(LocalDate.of(2021, 10, 03));
		
		Treatment updTreatment = treatmentService.updateTreatmentDateByTreatmentId(1,t);
		assertEquals(LocalDate.of(2021, 10, 03), updTreatment.getTreatmentDate());
	}
	
}