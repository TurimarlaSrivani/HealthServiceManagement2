package com.hsm.healthservicemanagement.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.dto.LoginDto;
import com.hsm.healthservicemanagement.entity.Login;
import com.hsm.healthservicemanagement.exception.InvalidCredentialsException;
import com.hsm.healthservicemanagement.exception.UserNotFoundException;
import com.hsm.healthservicemanagement.repository.ILoginRepository;


@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	
	@Override
	public String logout(String userId) {
		Optional<Login> userfield = loginRepo.findById(userId);
		Login dbUsr = null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		if (dbUsr != null && dbUsr.getUserid().equals(userId) && dbUsr.isLoggedIn()) {

			dbUsr.setLoggedIn(false);
			loginRepo.save(dbUsr);
			return "logout successfully";
		}
		throw new UserNotFoundException("User not logged in");
	}
	
	@Override
	public LoginDto login(Login user) {
		Optional<Login> opt = loginRepo.findById(user.getUserid());
		if(!opt.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		Login dbLogin = opt.get();
		if(dbLogin.getPassword().equals(dbLogin.getPassword()) && dbLogin.getRole().equals(dbLogin.getRole())) {
			// set isLoggedIn flag to true
			dbLogin.setLoggedIn(true);
			
			// update isLoggedIn flag to true 
			loginRepo.save(dbLogin);
			LoginDto dto = new LoginDto();
			dto.setUserId(user.getUserid());
			dto.setRole(user.getRole());
			dto.setLoggedIn(true);
			
			return dto;
		}
		else {
			throw new InvalidCredentialsException("Invalid credentials");
		}
	}
	
}
