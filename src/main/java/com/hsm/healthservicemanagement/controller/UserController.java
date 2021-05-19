package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.User;
import com.hsm.healthservicemanagement.exception.UserNotFoundException;
import com.hsm.healthservicemanagement.service.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService regservice;

	@GetMapping("/user/userid/{userid}")
	public User findUserByUserId(@PathVariable String userid) throws Exception {
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with this userid ");
		}
		return regservice.findUserByUserId(userid);
	}

	@GetMapping("/user/findallusers")
	public List<User> findAllusers() {
		return regservice.getAllUsers();

	}

	@PostMapping("/user/save")
	public User save(@RequestBody User register) throws Exception {
		return regservice.save(register);
	}

	@PutMapping("/user/{userid}/update")
	public User updateUser(@PathVariable String userid, @RequestBody User register) throws Exception {
		return regservice.updateUser(register);
	}

	@DeleteMapping("/user/{userid}")
	public User deleteUserByUserId(@PathVariable String userid) {
		return regservice.deleteUserByUserId(userid);
	}
}
