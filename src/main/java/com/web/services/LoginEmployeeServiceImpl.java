package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.LoginEmployee;
import com.web.repository.LoginEmployeeRepository;

@Service
public class LoginEmployeeServiceImpl implements LoginEmployeeService {

	@Autowired
	private LoginEmployeeRepository loginEmployeeRepo;

	@Override
	public Optional<LoginEmployee> getLoginEmployee(int employeeId) {
		return loginEmployeeRepo.getLoginEmployeeByCostomId(employeeId);
	}

	@Override
	public List<LoginEmployee> getAllLoginEmployee() {
		return loginEmployeeRepo.findAll();
	}

	@Override
	public void saveLoginEmployee(LoginEmployee loginEmployee) {
		loginEmployeeRepo.save(loginEmployee);
	}

}
