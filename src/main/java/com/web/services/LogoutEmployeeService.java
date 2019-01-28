package com.web.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.web.entity.LogoutEmployee;

public interface LogoutEmployeeService {

	Optional<LogoutEmployee> getLogoutEmployeeByCostomId(int employeeId);

	void deleteByEmployeeId(int employeeId);

	List<LogoutEmployee> getAllLogoutEmployeee();

	void saveLogoutEmployee(LogoutEmployee logoutEmployee);

	LocalDateTime getEmpLogoutDateTimeById(int employeeId);

	LocalDateTime getLatestLogoutLocalDateTime();

	LogoutEmployee getLatestLogoutEmployee();
}
