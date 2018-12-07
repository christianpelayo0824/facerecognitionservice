package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.EmployeePersonalInfo;

//Repository for CRUD operation in Employee entity using JpaRepository library
@Repository
public interface EmployeePersonalInfoRepository extends JpaRepository<EmployeePersonalInfo, Integer> {

}
