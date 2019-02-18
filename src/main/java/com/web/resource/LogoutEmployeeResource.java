package com.web.resource;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.LogoutEmployee;
import com.web.entity.Reason;
import com.web.services.LoginEmployeeService;
import com.web.services.LogoutEmployeeService;
import com.web.services.ReasonService;
import com.web.services.StationService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/resource/logoutEmployee")
public class LogoutEmployeeResource {

	@Autowired
	private LogoutEmployeeService logoutEmployeeService;

	@Autowired
	private LoginEmployeeService loginEmployeeService;

	@Autowired
	private ReasonService reasonService;

	@Autowired
	private StationService stationService;

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
	@PostMapping(value = "/currentTimeGap", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean currentTimeGapStatus(@RequestBody final LogoutEmployee logoutEmployee) {

		boolean status = false;

		if (stationService.isExistsEmployee(logoutEmployee.getEmployeeId(), logoutEmployee.getPhysicalStation())) {
			Reason reason = new Reason();
			if (loginEmployeeService.getEmpLoginDateTimeById(logoutEmployee.getEmployeeId())
					.getDayOfMonth() == LocalDateTime.now().getDayOfMonth()) {
				if ((LocalDateTime.now().getHour() - loginEmployeeService
						.getEmpLoginDateTimeById(logoutEmployee.getEmployeeId()).getHour()) <= 8) {

					/*
					 * Save the logout employee
					 *
					 */
					logoutEmployee.setEmployeeId(logoutEmployee.getEmployeeId()).setDate_time(LocalDateTime.now())
							.setStatus("--- UNDER_TIME---").setPhysicalStation(logoutEmployee.getPhysicalStation());
					logoutEmployeeService.saveLogoutEmployee(logoutEmployee);

				} else {
					/*
					 * Set reason if the current timestamp is greater than or equals 8 hours with
					 * the assign reason
					 */
					reason.setEmployeeId(logoutEmployee.getEmployeeId()).setReason("--- IN TIME---")
							.setLocalDateTime(LocalDateTime.now());
					reasonService.saveReason(reason);
					/*
					 * Save the logout employee
					 *
					 */
					logoutEmployee.setEmployeeId(logoutEmployee.getEmployeeId()).setDate_time(LocalDateTime.now())
							.setStatus("--- IN TIME---").setPhysicalStation(logoutEmployee.getPhysicalStation());
					logoutEmployeeService.saveLogoutEmployee(logoutEmployee);
				}
			}
			status = true;
		} else {
			status = false;
		}

		return status;

	}

	/*
	 * Set Emergency Reason if the status is under-time
	 */
	@PostMapping(value = "/isSetEmergencyReason", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean isSetEmergencyReason(@RequestBody final Reason reason) {
		LogoutEmployee logoutEmployee = new LogoutEmployee();
		logoutEmployee = logoutEmployeeService.getLatestLogoutEmployee();
		reason.setEmployeeId(logoutEmployee.getEmployeeId()).setLocalDateTime(logoutEmployee.getDate_time());
		reasonService.saveReason(reason);
		return true;
	}

	@GetMapping(value = "/findByPhysicalStation/{physicalStation}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LogoutEmployee> findByPhysicalStation(@PathVariable("physicalStation") final String physicalStation) {
		return logoutEmployeeService.findByPhysicalStation(physicalStation);
	}

	@GetMapping(value = "/countAllLogoutEmployeeByStation/{station}", produces = MediaType.APPLICATION_JSON_VALUE)
	public int countAllLogoutEmployeeByStation(@PathVariable("station") final String station) {
		return logoutEmployeeService.countAllLogoutEmployeeByStation(station);
	}

}
