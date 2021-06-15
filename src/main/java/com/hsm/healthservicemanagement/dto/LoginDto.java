package com.hsm.healthservicemanagement.dto;

import lombok.Data;

@Data
public class LoginDto {

		private String userId;
		private boolean isLoggedIn;
		private String role;

	}

