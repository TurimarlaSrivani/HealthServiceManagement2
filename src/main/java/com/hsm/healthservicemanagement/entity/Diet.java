package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Diet
{
	@Id
	private int dietId;
	private String dietType;
	private String foodtoEat;
	private int dietDuration;

	// Constructors
	public Diet() {
	}

	public Diet(int dietId, String dietType, String foodtoEat, int dietDuration) {
		super();
		this.dietId = dietId;
		this.dietType = dietType;
		this.foodtoEat = foodtoEat;
		this.dietDuration = dietDuration;
	}

	// getters and setters
	public int getDietId() {
		return dietId;
	}

	public void setDietId(int dietId) {
		this.dietId = dietId;
	}

	public int getDietDuration() {
		return dietDuration;
	}

	public void setDietDuration(int dietDuration) {
		this.dietDuration = dietDuration;
	}

	public String getDietType() {

		return dietType;
	}

	public void setDietType(String dietType) {
		this.dietType = dietType;
	}

	public String getFoodtoEat() {
		return foodtoEat;
	}

	public void setFoodtoEat(String foodtoEat) {
		this.foodtoEat = foodtoEat;
	}

}