package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, String> {


}