package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Diet;

@SpringBootTest

public class DietServiceTest {

	@Autowired
	IDietService dtService;

	// viewAllDietDetails
	@Test
	void testViewAllDiet() {
		List<Diet> diet = dtService.viewAll();
		assertEquals(3, diet.size());

	}

	// viewDietById
	@Test
	void testViewDietById() {
		Diet diet = dtService.viewDietById(101);
		assertEquals("keto", diet.getDietType());

	}

	// save Diet
	@Test
	void testSaveDiet() {

		Diet diet = new Diet(104,"low-crab","nuts","one week");
		Diet persistedDi = dtService.save(diet);
		assertEquals("low-crab", persistedDi.getDietType());
		assertEquals(104, persistedDi.getDietId());
		assertEquals("nuts", persistedDi.getFoodtoEat());
		assertEquals("one week", persistedDi.getDietDuration());
	}

	// delete diet
	@Test
	void testDelete() {

		Diet diet = new Diet(104 , "low-crab", "nuts", "one week");
		Diet persistedDi = dtService.delete(diet);
		assertEquals("low-crab", persistedDi.getDietType());
		assertEquals(104, persistedDi.getDietId());
		assertEquals("nuts", persistedDi.getFoodtoEat());
		assertEquals("one week", persistedDi.getDietDuration());
	}

	// update
	@Test
	public void updateDiet() {
		Diet d = new Diet();
		d.setDietId(103);
		d.setDietType("low-crab");
		d.setFoodtoEat("nuts");
		d.setDietDuration("two days");
	}

}
