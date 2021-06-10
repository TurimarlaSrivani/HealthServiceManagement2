package com.hsm.healthservicemanagement.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Login;
import com.hsm.healthservicemanagement.exception.UserNotFoundException;
import com.hsm.healthservicemanagement.repository.ILoginRepository;


@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	


	@Override
	public String login(Login user) {
		Optional<Login> dbUsr = loginRepo.findById(user.getUserid());
		String message = null;
		if (!dbUsr.isPresent() || !dbUsr.get().isLoggedIn()) {
			user.setLoggedIn(true);
			loginRepo.save(user);
			message = "Succesfully logged in " + user.getUserid();
		} else {
			message = "Already logged in " + user.getUserid();
		}

		return message;
	}

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
	
	
}
