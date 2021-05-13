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
	
	//viewAllDietDetails
	@Test
	void testViewAllDiet() {
		List<Diet> diet=dtService.viewAll();
		assertEquals(1,diet.size());
		
	}
	
	//viewDietById
	@Test
	void testViewDietById() {
		Diet diet = dtService.viewDietById(30);
		assertEquals("veggieiet",diet.getDietType());
			
	}
	
	//save
	@Test
	void testSaveDiet() {
		
	Diet diet = new Diet(40,"cardinodiet","vegetables",50);
	Diet persistedDi=dtService.save(diet);
	assertEquals("cardinodiet",persistedDi.getDietType());
	assertEquals(40,persistedDi.getDietId());
    assertEquals("vegetables",persistedDi.getFoodtoEat());
	}
	
	//delete
	@Test
	void testDeleteDiet() {
	
	Diet diet = new Diet(40,"cardinodiet","vegetables",50);
	Diet persistedDi=dtService.delete(diet);
	assertEquals("cardinodiet",persistedDi.getDietType());
	assertEquals(40,persistedDi.getDietId());
	assertEquals("vegetables",persistedDi.getFoodtoEat());	
	
	}
	//update
	@Test
	  public void updateDiet() {
		Diet d = new Diet();
		d.setDietId(30);
		d.setDietType("cardinodiet");
		d.setFoodtoEat("fruits");	
		d.setDietDuration(40);
	}
    
   //deleteDietById
   @Test
   public void deleteDiet()
   {
	   Diet d = dtService.deleteDiet(30);
	   assertEquals(30,d.getDietId());
   }

}




