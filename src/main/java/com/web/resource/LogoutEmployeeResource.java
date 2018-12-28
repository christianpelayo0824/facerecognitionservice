package com.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.LogoutEmployee;
import com.web.services.LogoutEmployeeService;

@RestController
@RequestMapping(value = "/api/resource/logoutEmployee")
public class LogoutEmployeeResource {

	@Autowired
	private LogoutEmployeeService logoutEmployeeService;

	/*
	 * - READ all
	 */	
	@GetMapping(value = "/getAllLogoutEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LogoutEmployee> getAllLogoutEmployee() {
		return logoutEmployeeService.getAllLogoutEmployeee();
	}
}
