package com.web.services;

import java.time.LocalDateTime;
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
	public Optional<LoginEmployee> getLoginEmployeeByCostomId(int employeeId) {
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

	@Override
	public void deleteByEmployeeId(int employeeId) {
		loginEmployeeRepo.deleteByEmployeeId(employeeId);

	}

	@Override
	public LocalDateTime getEmpLoginDateTimeById(int employeeId) {
		return loginEmployeeRepo.getEmpLoginDateTimeById(employeeId);
	}

	@Override
	public List<LoginEmployee> findByPhysicalStation(String physicalStation) {
		return loginEmployeeRepo.findByPhysicalStation(physicalStation);
	}

	@Override
	public int countAllLoginEmployeeByStation(String station) {
		return loginEmployeeRepo.countAllLoginEmployeeByStation(station);
	}

}
