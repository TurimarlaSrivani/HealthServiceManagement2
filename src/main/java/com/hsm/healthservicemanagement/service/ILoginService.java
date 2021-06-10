package com.hsm.healthservicemanagement.service;

import com.hsm.healthservicemanagement.entity.Login;
public interface ILoginService {
	/*
	 * Login User
	 */
	String login(Login user);
/*
 * Logout User
 */
	String logout(String userId);

}
