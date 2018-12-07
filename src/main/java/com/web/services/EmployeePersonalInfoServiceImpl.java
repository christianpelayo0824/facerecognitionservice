package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.EmployeePersonalInfo;
import com.web.repository.EmployeePersonalInfoRepository;

//Employee class with employee service implementation for creating query
@Service
public class EmployeePersonalInfoServiceImpl implements EmployeePersonalInfoService {

	@Autowired
	EmployeePersonalInfoRepository emplRepo;

	@Override
	public List<EmployeePersonalInfo> getAllEmployee() {
		return emplRepo.findAll();
	}

	@Override
	public void createEmployee(EmployeePersonalInfo employee) {
		emplRepo.save(employee);
	}

	@Override
	public void updateEmployee(EmployeePersonalInfo employee) {
		emplRepo.save(employee);
	}

	@Override
	public Optional<EmployeePersonalInfo> getEmployeeById(int employeeId) {
		return (Optional<EmployeePersonalInfo>) emplRepo.findById(employeeId);
	}

	@Override
	public void deleteStudent(int employeeId) {
		emplRepo.deleteById(employeeId);
	}

}
