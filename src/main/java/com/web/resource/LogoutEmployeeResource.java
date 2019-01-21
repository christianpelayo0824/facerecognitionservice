package com.web.resource;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.LogoutEmployee;
import com.web.services.LoginEmployeeService;
import com.web.services.LogoutEmployeeService;

@RestController
@RequestMapping(value = "/api/resource/logoutEmployee")
public class LogoutEmployeeResource {

	@Autowired
	private LogoutEmployeeService logoutEmployeeService;

	@Autowired
	LoginEmployeeService loginEmployeeService;

	/*
	 * - READ all employee from logout mode
	 */
	@GetMapping(value = "/getAllLogoutEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LogoutEmployee> getAllLogoutEmployee() {
		return logoutEmployeeService.getAllLogoutEmployeee();
	}

	/*
	 * - Save employee in logout mode
	 */	
	@PostMapping(value = "/saveLogoutEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean saveLogoutEmployee(@RequestBody LogoutEmployee logoutEmployee) {
		logoutEmployee.setDate_time(LocalDateTime.now());
		logoutEmployeeService.saveLogoutEmployee(logoutEmployee);
		return true;
	}

	/*
	 * Check if the time gap of the current day is greater than 8 hours
	 */
	@GetMapping(value = "/currentTimeGap/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean checkDateOfMonthStatus(@PathVariable("employeeId") final int employeeId) {
		boolean status = false;

		if (loginEmployeeService.getEmpLoginDateTimeById(employeeId).getDayOfMonth() == LocalDateTime.now()
				.getDayOfMonth()) {
			if ((LocalDateTime.now().getHour()
					- loginEmployeeService.getEmpLoginDateTimeById(employeeId).getHour()) >= 8) {
				status = true;
			}
		}
		return status;
	}
}
