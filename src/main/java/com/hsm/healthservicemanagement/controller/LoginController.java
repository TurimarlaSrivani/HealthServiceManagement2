package com.hsm.healthservicemanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.User;
import com.hsm.healthservicemanagement.dto.LoginDto;
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
	public ResponseEntity<LoginDto> Login(@RequestBody Login user)  {
		//String message=null;
		/*if (user.getUserid()==null || user.getPassword()==null || user.getUserid().equals("")||user.getPassword().equals("")) {
			throw new UserNotFoundException("Userid or Password is invalid");
		}	*/
		LoginDto dto = loginService.login(user);
		return new ResponseEntity<>(dto, HttpStatus.OK);

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
