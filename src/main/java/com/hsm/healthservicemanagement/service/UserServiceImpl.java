package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.UserEntity;
import com.hsm.healthservicemanagement.exception.UserNotFoundException;
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
	public UserEntity createUser(UserEntity user){
		
		Optional<UserEntity> optional =regRepo.findById(user.getUserId());
		if(optional.isPresent()) {
			throw new UserNotFoundException("UserId already exists");
		}
		return regRepo.save(user);

	}

	@Override
	public UserEntity findUserByUserId(String userId) {
		Optional<UserEntity> optional = regRepo.findById(userId);
		if (!optional.isPresent()) {
			return null;
		}

		return optional.get();
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return regRepo.findAll();
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		UserEntity dbUser = getUser(user);
		if (isNullOrEmpty(dbUser.getFirstName())) {
			dbUser.setFirstName(user.getFirstName());
		}
		if (isNullOrEmpty(dbUser.getLastName())) {
			dbUser.setLastName(user.getLastName());
		}
		if (isNullOrEmpty(dbUser.getEmail())) {
			dbUser.setEmail(user.getEmail());
		}
		if (isNullOrEmpty(dbUser.getPassword())) {
			dbUser.setPassword(user.getPassword());
		}
		if (isNullOrEmpty(dbUser.getMobileNumber())) {
			dbUser.setMobileNumber(user.getMobileNumber());
		}
		return regRepo.save(dbUser);
	}

	private boolean isNullOrEmpty(String value) {
		return value != null && !value.equals("");
	}

	private UserEntity getUser(UserEntity user) {
		Optional<UserEntity> userfield = regRepo.findById(user.getUserId());
		UserEntity dbUser=null;
		if (userfield.isPresent()) {
			dbUser = userfield.get();
		}
		return dbUser;
	}

	@Override
	public UserEntity deleteUserByUserId(String userId) {
		Optional<UserEntity> optional = regRepo.findById(userId);
		if (!optional.isPresent()) {
			return null;
		}
		regRepo.deleteById(userId);
		return optional.get();
	}
}