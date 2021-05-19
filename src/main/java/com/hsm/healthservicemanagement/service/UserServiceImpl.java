package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.User;
import com.hsm.healthservicemanagement.repository.IUserRepository;
import com.hsm.healthservicemanagement.validationhandler.Validate;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository regRepo;

	@Override
	public User save(User user) throws Exception {
		Validate.validateUser(user);
		return regRepo.save(user);

	}

	@Override
	public User findUserByUserId(String userid) throws Exception {
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
	public User updateUser(User user) throws Exception {
		User dbUser = regRepo.findById(user.getUserid()).get();
		if (dbUser != null) {
			if (user.getFirstname() != null && !user.getFirstname().equals("")) {
				dbUser.setFirstname(user.getFirstname());
			}
			if (user.getLastname() != null && !user.getLastname().equals("")) {
				dbUser.setLastname(user.getLastname());
			}
			if (user.getEmail() != null && !user.getEmail().equals("")) {
				dbUser.setEmail(user.getEmail());
			}
			if (user.getPassword() != null && !user.getPassword().equals("")) {
				dbUser.setPassword(user.getPassword());
			}
			if (user.getMobile_no() != null && !user.getMobile_no().equals("")) {
				dbUser.setMobile_no(user.getMobile_no());
			}
		}
		Validate.validateUser(dbUser);
		return regRepo.save(dbUser);
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
