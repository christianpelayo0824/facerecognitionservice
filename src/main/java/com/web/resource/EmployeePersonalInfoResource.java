package com.web.resource;

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

import com.web.entity.EmployeePersonalInfo;
import com.web.services.EmployeePersonalInfoService;

/*
Rest end-point for employee in JSON format
*/
@RestController
@CrossOrigin
@RequestMapping(value = "/api/resource/employee")
public class EmployeePersonalInfoResource {

	@Autowired
	private EmployeePersonalInfoService emplService;

	/*
	 * - READ 
	 * - Rest end-point to retrieve data via employee service
	 */
	@GetMapping(value = "/getAllEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeePersonalInfo> getAllEmployee() {
		return emplService.getAllEmployee();
	}

	/*
	 * - CREATE 
	 * - Rest end-point to create data via employee service
	 */
	@PostMapping(value = "/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean createEmployee(@RequestBody EmployeePersonalInfo employee) {
		emplService.createEmployee(employee);
		return true;
	}

	/*
	 * - UPDATE 
	 * - Rest end-point to update data via employee service
	 */
	@PutMapping(value = "/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateEmployee(@RequestBody EmployeePersonalInfo employee) {
		emplService.updateEmployee(employee);
		return true;

	}

	/*
	 * - READ by id 
	 * - Rest end-point to get employee using id via employee service
	 */
	@GetMapping(value = "/getEmployeeById/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<EmployeePersonalInfo> getEmployeeById(@PathVariable("employeeId") final int employeeId) {
		return (Optional<EmployeePersonalInfo>) emplService.getEmployeeById(employeeId);
	}

	/*
	 * - DELETE by id 
	 * - Rest end-point to delete data via employee service
	 */
	@DeleteMapping(value = "/deleteEmployeeById/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteEmployeeById(@PathVariable("employeeId") final int employeeId) {
		emplService.deleteStudent(employeeId);
		return true;
	}

}
