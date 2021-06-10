package com.hsm.healthservicemanagement.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.User;


@Service
public interface IUserService {
	/**
	 * Retrieves user records with userid
	 * @param userid
	 * @return UserEntity
	 */
	public User findUserByUserId(String userid);
/**
 * Retrieves user
 * @return
 */
	public List<User> getAllUsers();
	/**
	 * Creates user record in the entity table
	 * @param UserEntity
	 * @return UserEntity
	 */
	public User createUser(User user);

	public User updateUser(User user);

	public User deleteUserByUserId(String userid);

}