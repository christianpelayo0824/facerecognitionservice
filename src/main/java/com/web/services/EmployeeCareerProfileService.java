package com.web.services;

import java.util.List;
import java.util.Optional;

import com.web.entity.EmployeeCareerProfile;

public interface EmployeeCareerProfileService {

	public List<EmployeeCareerProfile> getAllCareerProfile();

	public void createCareerProfile(EmployeeCareerProfile careerProfile);

	public void updateCareerProfile(EmployeeCareerProfile careerProfile);

	public Optional<EmployeeCareerProfile> getCareerProfileById(int careerProfileID);

	public void deleteCareerProfileById(final int careerProfileID);
}