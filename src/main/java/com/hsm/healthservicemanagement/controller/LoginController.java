package com.hsm.healthservicemanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.User;
import com.hsm.healthservicemanagement.entity.Login;
import com.hsm.healthservicemanagement.exception.UserNotFoundException;
import com.hsm.healthservicemanagement.service.ILoginService;
import com.hsm.healthservicemanagement.service.IUserService;

@CrossOrigin
@RestController
public class LoginController {
	/*
	 * Logger
	 */
	Logger logger =LogManager.getLogger(LoginController.class);
	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	ILoginService loginService;
	@Autowired
	IUserService  userService;
	/*
	 *  performs Login operation
	 */
	@PostMapping("/login")
	public String Login(@RequestBody Login login) {
		String message=null;
		if (login.getUserid()==null || login.getPassword()==null || login.getUserid().equals("")||login.getPassword().equals("")) {
			throw new UserNotFoundException("Userid or Password is invalid");
		}	
		User userfield = userService.findUserByUserId(login.getUserid());
		if(userfield !=null && userfield.getPassword().equals(login.getPassword())) {
			message = loginService.login(login);
		}
		else if(userfield!=null){
			throw new UserNotFoundException("Userid or Password is5 invalid");
		}
		else  {
			throw new UserNotFoundException("User Not Registered");
		}
		return message;
	}
    /*
     * performs logout operation
     */
	@GetMapping("/logout/{userId}")
	public String Logout( @PathVariable("userId")String userId){
		logger.info("logout Sucessfully");
		return loginService.logout(userId);
	}

}
