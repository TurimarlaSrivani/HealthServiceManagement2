package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "login")
public class Login {

	@Id
	@NotEmpty(message="Please enter your userid")
	private String userid;
	@NotEmpty(message="Please enter your password")
	private String password;
	@JsonIgnore
    private boolean isLoggedIn = false;
    private String role;
}
