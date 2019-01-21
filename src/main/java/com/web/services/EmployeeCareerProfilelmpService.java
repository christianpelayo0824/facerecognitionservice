package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.EmployeeCareerProfile;
import com.web.repository.EmployeeCareerProfileRepository;

@Service
public class EmployeeCareerProfilelmpService implements EmployeeCareerProfileService {

	@Autowired
	private EmployeeCareerProfileRepository employeeCareerProfileRepo;

	@Override
	public List<EmployeeCareerProfile> getAllCareerProfile() {
		return employeeCareerProfileRepo.findAll();
	}

	@Override
	public void createCareerProfile(EmployeeCareerProfile careerProfile) {
		employeeCareerProfileRepo.save(careerProfile);
	}

	@Override
	public void updateCareerProfile(EmployeeCareerProfile careerProfile) {
		employeeCareerProfileRepo.save(careerProfile);

	}

	@Override
	public Optional<EmployeeCareerProfile> getCareerProfileById(int careerProfileId) {
		return employeeCareerProfileRepo.findById(careerProfileId);
	}

	@Override
	public void deleteCareerProfileById(int careerProfileId) {
		employeeCareerProfileRepo.deleteById(careerProfileId);
	}

	@Override
	public int getEmployeeIdbyId(int id) {
		return employeeCareerProfileRepo.getEmployeeIdById(id);
	}

	@Override
	public List<String> getDistinctStation() {
		return employeeCareerProfileRepo.getDistinctStation();
	}

}
