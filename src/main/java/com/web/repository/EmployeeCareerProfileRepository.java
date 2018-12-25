package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.EmployeeCareerProfile;

@Repository
public interface EmployeeCareerProfileRepository extends JpaRepository<EmployeeCareerProfile, Integer> {

}
