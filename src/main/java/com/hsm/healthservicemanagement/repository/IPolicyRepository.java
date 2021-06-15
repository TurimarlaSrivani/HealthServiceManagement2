package com.hsm.healthservicemanagement.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Policy;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Integer> {
    public Optional<Policy> findById(int id);
}
