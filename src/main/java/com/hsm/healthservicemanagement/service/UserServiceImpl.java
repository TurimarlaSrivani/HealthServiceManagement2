package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.User;
import com.hsm.healthservicemanagement.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository regRepo;
/**
 * creating a user in database
 * 
 */
	@Override
	public User createUser(User user){
		return regRepo.save(user);

	}

	@Override
	public User findUserByUserId(String userid) {
		Optional<User> optional = regRepo.findById(userid);
		if (!optional.isPresent()) {
			return null;
		}

		return optional.get();
	}

	@Override
	public List<User> getAllUsers() {
		return regRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		User dbUser = getUser(user);
		if (isNullOrEmpty(dbUser.getUserName())) {
			dbUser.setUserName(user.getUserName());
		}
		if (isNullOrEmpty(dbUser.getEmail())) {
			dbUser.setEmail(user.getEmail());
		}
		if (isNullOrEmpty(dbUser.getMobileNo())) {
			dbUser.setMobileNo(user.getMobileNo());
		}
		if (isNullOrEmpty(dbUser.getRole())) {
			dbUser.setRole(user.getRole());
		}
		return regRepo.save(dbUser);
	}

	private boolean isNullOrEmpty(String value) {
		return value != null && !value.equals("");
	}

	private User getUser(User user) {
		Optional<User> userfield = regRepo.findById(user.getUserid());
		User dbUser=null;
		if (userfield.isPresent()) {
			dbUser = userfield.get();
		}
		return dbUser;
	}

	@Override
	public User deleteUserByUserId(String userid) {
		Optional<User> optional = regRepo.findById(userid);
		if (!optional.isPresent()) {
			return null;
		}
		regRepo.deleteById(userid);
		return optional.get();
	}
}