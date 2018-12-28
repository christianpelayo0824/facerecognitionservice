package com.web.resource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.LoginEmployee;
import com.web.services.LoginEmployeeService;

@RestController
@RequestMapping(value = "/api/resource/loginEmployee")
public class LoginEmployeeResource {

	@Autowired
	private LoginEmployeeService loginEmployeeService;

	/*
	 * - READ by custom id 
	 * - Rest end-point in retrieving LoginEmoloyee using custom
	 * employee_id. 
	 *  - example :
	 * 	- employee_id : 12345678
	 */
	@GetMapping(value = "/getLoginEmployeeByCustomId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<LoginEmployee> getLoginEmployeeByCustomId(@PathVariable("employeeId") final int employeeId) {
		return loginEmployeeService.getLoginEmployeeByCostomId(employeeId);
	}

	/*
	 * - READ all
	 * - Rest end-point in retrieving all LoginEmployee
	 */	 
	@GetMapping(value = "/getAllLoginEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LoginEmployee> getAllLoginEmployee() {
		return loginEmployeeService.getAllLoginEmployee();
	}

	/*
	 * - CREATE 
	 * - Rest end-point in creating LoginEmployee
	 */	 
	@PostMapping(value = "/saveLoginEmployee/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean saveLoginEmployee(@PathVariable("employeeId") final int employeeId) {
		boolean status = false;

		LoginEmployee loginEmployee = new LoginEmployee();
		if (loginEmployee.getEmpCareerProfile() == null) {
			loginEmployee.setDateTime(LocalDateTime.now()).setEmployeeId(employeeId);
			loginEmployeeService.saveLoginEmployee(loginEmployee);
			status = true;
		} else {
			status = false;
		}

		return status;
	}

}
