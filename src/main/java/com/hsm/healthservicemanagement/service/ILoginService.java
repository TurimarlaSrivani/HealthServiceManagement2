package com.hsm.healthservicemanagement.service;

import com.hsm.healthservicemanagement.dto.LoginDto;
import com.hsm.healthservicemanagement.entity.Login;
public interface ILoginService {
	/*
	 * Login User
	 */
	LoginDto login(Login user);
	//String logindto(Login user);
/*
 * Logout User
 */
	String logout(String userId);

}
