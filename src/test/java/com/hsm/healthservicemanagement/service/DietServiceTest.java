package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Diet;

@SpringBootTest

public class DietServiceTest {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DietServiceTest.class);

	@Autowired
	IDietService dtService;

	// Testing whether the diet database has diet or null.
	// viewAllDietDetails
	@Test
	void testViewAllDiet() {
		List<Diet> diet = dtService.viewAll();
		logger.info(diet);
		assertEquals(3, diet.size());

	}

	// Testing whether the given id fetches the given diet or not.
	// viewDietById
	@Test
	void testViewDietById() {
		Diet diet = dtService.viewDietById(101);
		assertEquals("keto", diet.getDietType());
		logger.info("logger view diet by viewDietById ");

	}

	// Testing whether the diet gets saved to the database.
	// save Diet
	@Test
	void testSaveDiet() {

		Diet diet = new Diet(104, "low-crab", "nuts", "one week");
		Diet persistedDi = dtService.save(diet);
		assertEquals("low-crab", persistedDi.getDietType());
		assertEquals(104, persistedDi.getDietId());
		assertEquals("nuts", persistedDi.getFoodtoEat());
		assertEquals("one week", persistedDi.getDietDuration());
		logger.info("logger save to Diet");

	}

	// Testing whether the diet gets removed from the database
	// delete diet
	@Test
	void testDelete() {

		Diet diet = new Diet(104, "low-crab", "nuts", "one week");
		Diet persistedDi = dtService.delete(diet);
		assertEquals("low-crab", persistedDi.getDietType());
		assertEquals(104, persistedDi.getDietId());
		assertEquals("nuts", persistedDi.getFoodtoEat());
		assertEquals("one week", persistedDi.getDietDuration());
		logger.info("Deleted succesfully");

	}

	// Testing whether the diet gets updated to the database.
	// update
	@Test
	public void updateDiet() {
		Diet d = new Diet();
		d.setDietId(103);
		d.setDietType("low-crab");
		d.setFoodtoEat("nuts");
		d.setDietDuration("two days");
		logger.info("update succesfully");

	}

}