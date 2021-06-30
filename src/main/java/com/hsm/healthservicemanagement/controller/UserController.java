package com.hsm.healthservicemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.UserEntity;
import com.hsm.healthservicemanagement.exception.UserNotFoundException;
import com.hsm.healthservicemanagement.service.IUserService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	/**
	 * Logger
	 */
	Logger logger =LogManager.getLogger(UserController.class);
	
	/**
	 * AutoWiring the service class to call down the service
	 */

	@Autowired
	IUserService regservice;
	
	/**
	 * This below function is used to get a specific user using userid 
	 * and redirects to the user service
	 */

	
	@GetMapping("/users/{userId}")
	public UserEntity findUserByUserId(@PathVariable String userId){
		if (regservice.findUserByUserId(userId) == null) {
			throw new UserNotFoundException("User not found with this userid ");
		}
		logger.info("Getting User by UserId:"+ userId);
		return regservice.findUserByUserId(userId);
		
		
		 
	}
	/**
	 * This below function is used to get all the user and redirects to the
	 * user service
	 */

	@GetMapping("/users")
	public List<UserEntity> findAllusers() {
		logger.info("Printing all the Users");
		return regservice.getAllUsers();

	}
	/**
	 * This below function is used to create a new user and redirects to the
	 * user service
	 */
	@PostMapping("/users/add")
	public UserEntity save(@Valid @RequestBody UserEntity user){
		logger.info("Creating a User");
		return regservice.createUser(user);
	}


	/**
	 * This below function is used to update a specific user based on the give
	 * userid and redirects to the user service
	 */
	
	@PutMapping("/users/update/{userId}")
	public UserEntity updateUser(@PathVariable String userId,@Valid @RequestBody UserEntity user){
		if (regservice.findUserByUserId(userId)==null) {
			throw new UserNotFoundException("User not found with this Userid" );
		}
		logger.info("Updating the User"+ userId);
		return regservice.updateUser(user);
		
	}
	/**
	 * This below function is used to delete a specific user based on the give
	 * userid and redirects to the user service
	 */
	
	@DeleteMapping("/users/{userId}")
	public UserEntity deleteUserByUserId(@PathVariable String userId){
		if(regservice.findUserByUserId(userId)==null){
		throw new UserNotFoundException("User not found with Userid");	
		}
		logger.info("Deleting the User by Userid"+ userId);
		return regservice.deleteUserByUserId(userId);
	}
}