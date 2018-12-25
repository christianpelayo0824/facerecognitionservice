package com.web.services;

import java.util.List;
import java.util.Optional;

import com.web.entity.LoginEmployee;

public interface LoginEmployeeService {

	public Optional<LoginEmployee> getLoginEmployee(int employeeId);

	public List<LoginEmployee> getAllLoginEmployee();

	public void saveLoginEmployee(LoginEmployee loginEmployee);
}
