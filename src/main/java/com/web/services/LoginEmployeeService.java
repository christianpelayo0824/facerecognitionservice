package com.web.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.web.entity.LoginEmployee;

public interface LoginEmployeeService {

	public Optional<LoginEmployee> getLoginEmployeeByCostomId(int employeeId);

	public List<LoginEmployee> getAllLoginEmployee();

	public void saveLoginEmployee(LoginEmployee loginEmployee);
	
	public void deleteByEmployeeId(int employeeId);
	
	public LocalDateTime getEmpLoginDateTimeById(int employeeId);

}
