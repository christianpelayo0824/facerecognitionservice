package com.web.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.web.entity.LoginEmployee;

public interface LoginEmployeeService {

	Optional<LoginEmployee> getLoginEmployeeByCostomId(int employeeId);

	List<LoginEmployee> getAllLoginEmployee();

	void saveLoginEmployee(LoginEmployee loginEmployee);

	void deleteByEmployeeId(int employeeId);

	LocalDateTime getEmpLoginDateTimeById(int employeeId);

	List<LoginEmployee> findByPhysicalStation(String physicalStation);

	int countAllLoginEmployeeByStation(String station);

}
