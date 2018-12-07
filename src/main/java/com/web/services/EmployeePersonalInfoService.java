package com.web.services;

import java.util.List;
import java.util.Optional;

import com.web.entity.EmployeePersonalInfo;

//Employee Interface as a service for database manipulation
public interface EmployeePersonalInfoService {

	public List<EmployeePersonalInfo> getAllEmployee();

	public void createEmployee(EmployeePersonalInfo employee);

	public void updateEmployee(EmployeePersonalInfo employee);

	public Optional<EmployeePersonalInfo> getEmployeeById(int employeeId);

	public void deleteStudent(int employeeId);

}
