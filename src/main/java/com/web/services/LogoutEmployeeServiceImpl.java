package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.LogoutEmployee;
import com.web.repository.LogoutEmployeeRepository;

@Service
public class LogoutEmployeeServiceImpl implements LogoutEmployeeService {

	@Autowired
	private LogoutEmployeeRepository logoutEmployeeRepo;

	@Override
	public Optional<LogoutEmployee> getLogoutEmployeeByCostomId(int employeeId) {
		return logoutEmployeeRepo.getLogoutEmployeeByCostomId(employeeId);
	}

	@Override
	public void deleteByEmployeeId(int employeeId) {
		logoutEmployeeRepo.deleteByEmployeeId(employeeId);
	}

	@Override
	public List<LogoutEmployee> getAllLogoutEmployeee() {
		return logoutEmployeeRepo.findAll();
	}

	@Override
	public void saveLogoutEmployee(LogoutEmployee logoutEmployee) {
		logoutEmployeeRepo.save(logoutEmployee);
	}

}
