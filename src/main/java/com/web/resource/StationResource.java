package com.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.Station;
import com.web.services.StationService;

@RestController
@RequestMapping(value = "/api/resource/station")
@CrossOrigin
public class StationResource {

	@Autowired
	private StationService stationService;

	@PostMapping(value = "/saveStation", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean saveStation(@RequestBody Station station) {
		boolean status = false;
		if(stationService.isExistsEmployee(station.getEmployeeId(), station.getStation()) != true) {
			stationService.saveStation(station);
			status = true;
		}
		return status;
	}

	@GetMapping(value = "/getAllStationData", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Station> getAllStationData() {
		return stationService.getAllStationData();
	}

	@DeleteMapping(value = "/deleteStationById/{employeeId}")
	public boolean deleteStationById(@PathVariable("employeeId") final int employeeId) {
		stationService.deleteStationById(employeeId);
		return true;
	}
	
	@DeleteMapping(value = "/deleteEmployeeFromStation/{employeeId}/{station}")
	public boolean deleteEmployeeFromStation(@PathVariable("employeeId") final int employeeId, @PathVariable("station") final String station) {
		stationService.deleteEmployeeFromStation(employeeId, station);
		return true;
	}

	@GetMapping(value = "/isExistsByEmployeeId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean isExistsByEmployeeId(@PathVariable("employeeId") final int employeeId) {
		return stationService.isExistsByEmployeeId(employeeId);
	}
	
	@GetMapping(value = "/isExistsEmployee/{employeeId}/{station}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean isExistsEmployee(@PathVariable("employeeId") final int employeeId, @PathVariable("station") final String station) {
		return stationService.isExistsEmployee(employeeId, station);
	}
	
	@GetMapping(value = "/getCareerProfileByStation/{station}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Station> getCareerProfileByStation(@PathVariable("station") final String station) {
		return stationService.getCareerProfileByStation(station);
	}

}
