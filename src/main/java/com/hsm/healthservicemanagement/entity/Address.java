package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
public class Address {
	
	@Id
    @GeneratedValue
    private int id;
	@NonNull
	private String streetName;
	@NonNull
	private String city;
	
}
