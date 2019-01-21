package com.web.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.web.entity.LogoutEmployee;

public interface LogoutEmployeeService {

	public Optional<LogoutEmployee> getLogoutEmployeeByCostomId(int employeeId);

	public void deleteByEmployeeId(int employeeId);

	public List<LogoutEmployee> getAllLogoutEmployeee();
	
	public void saveLogoutEmployee(LogoutEmployee logoutEmployee);
	
	public LocalDateTime getEmpLogoutDateTimeById(int employeeId);
}
