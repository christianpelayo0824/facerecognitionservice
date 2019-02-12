package com.web.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.EmployeeCareerProfile;
import com.web.helper.StationHelper;
import com.web.services.EmployeeCareerProfileService;
import com.web.services.LoginEmployeeService;
import com.web.services.LogoutEmployeeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/resource/career")
public class EmployeeCareerProfileResource {

	@Autowired
	private EmployeeCareerProfileService employeeCareerProfileService;

	@Autowired
	private LoginEmployeeService loginEmployeeService;

	@Autowired
	private LogoutEmployeeService logoutEmployeeService;

	/*
	 * - READ
	 */
	@GetMapping(value = "/getAllCareerProfile", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeCareerProfile> getAllCareerProfile() {
		return employeeCareerProfileService.getAllCareerProfile();
	}

	/*
	 * - READ by id
	 */
	@GetMapping(value = "/getCareerProfileById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<EmployeeCareerProfile> getCareerProfileById(@PathVariable("id") final int careerProfileId) {
		return (Optional<EmployeeCareerProfile>) employeeCareerProfileService.getCareerProfileById(careerProfileId);
	}

	/*
	 * - DELETE
	 */
	@DeleteMapping(value = "/deleteCareerProfileById/{id}")
	public boolean deleteProfileBId(@PathVariable("id") final int careerProfileId) {
		/*
		 * In this line of code loginService has been called so that it will synchronize
		 * in times when deleting the main entity which is this current class
		 */
		loginEmployeeService.deleteByEmployeeId(employeeCareerProfileService.getEmployeeIdbyId(careerProfileId));

		/*
		 * In this line of code logoutService has been called so that it will
		 * synchronize in times when deleting the main entity which is this current
		 * class
		 */
		logoutEmployeeService.deleteByEmployeeId(employeeCareerProfileService.getEmployeeIdbyId(careerProfileId));
		employeeCareerProfileService.deleteCareerProfileById(careerProfileId);
		return true;
	}

	/*
	 * - UPDATE
	 */
	@PutMapping(value = "/updateCareerProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateCareerProfile(@RequestBody final EmployeeCareerProfile employeeCareerProfile) {
		employeeCareerProfileService.updateCareerProfile(employeeCareerProfile);
		return true;
	}

	/*
	 * - CREATE
	 */
	@PostMapping(value = "/createCareerProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean createCareerProfile(@RequestBody final EmployeeCareerProfile employeeCareerProfile) {
		employeeCareerProfileService.createCareerProfile(employeeCareerProfile);
		return true;
	}

	/*
	 * Get available station
	 */
	@GetMapping(value = "/getDistinctStation", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StationHelper> getDistinctStation() {

		List<StationHelper> stationList = new ArrayList<>();

		int counter = 0;
		for (String station : employeeCareerProfileService.getDistinctStation()) {
			System.out.println(station);
			stationList.add(new StationHelper().setSid(counter).setStation(station));
			counter++;
		}
		return stationList;
	}

	@GetMapping(value = "/getCareerProfileByStation/{station}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeCareerProfile> getCareerProfileByStation(@PathVariable("station") final String station) {
		return employeeCareerProfileService.getCareerProfileByStation(station);
	}

}
