package com.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.Reason;
import com.web.services.ReasonService;

@RestController
@RequestMapping(value = "/api/resource/reason")
@CrossOrigin
public class ReasonResource {

	@Autowired
	private ReasonService reasonService;

	@GetMapping(value = "/findReasonByEmployeeId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reason> findReasonByEmployeeId(@PathVariable("employeeId") final int employeeId) {
		return reasonService.findByEmployeeId(employeeId);
	}

	@GetMapping(value = "/getReasonStatusById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reason> getReasonStatusById(@PathVariable("id") final int id) {
		return reasonService.getReasonStatusById(id);
	}

}
