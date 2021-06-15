package com.hsm.healthservicemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="register")
public class User {
	
	@Id
	private String userid;
	
	private String userName;
	private String email;
	private String mobileNo;
	private String role;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_fk")
	private Login login;

}