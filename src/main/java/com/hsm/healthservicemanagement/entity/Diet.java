package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Diet {
    
	@Id
	private int dietId;
	@NotEmpty  //Validation part
	@Size(min = 2, message = "type should have atleast 2 char")
	private String dietType;
	@NotEmpty(message = "Please Enter foodtoEat") //Validation part
	@Size(min = 5, max = 25, message = "Enter foodtoEat in between 5 and 9")
	private String foodtoEat;
	private String dietDuration;
}