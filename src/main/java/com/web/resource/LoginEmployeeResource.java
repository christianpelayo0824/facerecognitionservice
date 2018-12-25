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

	@GetMapping(value = "/getLoginEmployeeByCustomId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<LoginEmployee> getLoginEmployeeByCustomId(@PathVariable("employeeId") final int employeeId) {
		return loginEmployeeService.getLoginEmployee(employeeId);
	}

	@GetMapping(value = "/getAllLoginEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LoginEmployee> getAllLoginEmployee() {
		return loginEmployeeService.getAllLoginEmployee();
	}

	@PostMapping(value = "/saveLoginEmployee/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean saveLoginEmployee(@PathVariable("employeeId") final int employeeId) {
		LoginEmployee loginEmployee = new LoginEmployee();
		loginEmployee.setDateTime(LocalDateTime.now())
			.setEmployeeId(employeeId);
		loginEmployeeService.saveLoginEmployee(loginEmployee);
		return true;
	}

}
