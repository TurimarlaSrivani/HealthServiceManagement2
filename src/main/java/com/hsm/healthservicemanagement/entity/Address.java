package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
    @GeneratedValue
    private int id;
	private String streetName;
	private String city;
	
	//Constructors
	public Address() {}
	public Address(String streetName,String city)
	{
		this.streetName = streetName;
		this.city = city;
	}
	
	//Getters and Setters

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Override
	public String toString() {
		return "Address [id=" + id +",streetName=" + streetName + ", city=" + city + "]";
	}
}
