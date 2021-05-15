package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Diet;

@Repository
public interface IDietRepository extends JpaRepository<Diet, Integer> {
}