package com.web.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.EmployeeCareerProfile;
import com.web.services.EmployeeCareerProfileService;

@RestController
@RequestMapping(value = "/api/resource/career")
public class EmployeeCareerProfileResource {

	@Autowired
	private EmployeeCareerProfileService employeeCareerProfileService;

	@GetMapping(value = "/getAllCareerProfile", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeCareerProfile> getAllCareerProfile() {
		return employeeCareerProfileService.getAllCareerProfile();
	}

	@GetMapping(value = "/getCareerProfileById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<EmployeeCareerProfile> getCareerProfileById(@PathVariable("id") final int careerProfileId) {
		return (Optional<EmployeeCareerProfile>) employeeCareerProfileService.getCareerProfileById(careerProfileId);
	}

	@DeleteMapping(value = "/deleteCareerProfileById/{id}")
	public boolean deleteProfileBId(@PathVariable("id") final int careerProfileId) {
		employeeCareerProfileService.deleteCareerProfileById(careerProfileId);
		return true;
	}

	@PutMapping(value = "/updateCareerProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateCareerProfile(@RequestBody final EmployeeCareerProfile employeeCareerProfile) {
		employeeCareerProfileService.updateCareerProfile(employeeCareerProfile);
		return true;
	}

	@PostMapping(value = "/createCareerProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean createCareerProfile(@RequestBody final EmployeeCareerProfile employeeCareerProfile) {
		employeeCareerProfileService.createCareerProfile(employeeCareerProfile);
		return true;
	}

}
