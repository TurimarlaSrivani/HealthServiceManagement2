package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {

}