package com.web.services;

import java.util.List;

import com.web.entity.Station;

public interface StationService {

	void saveStation(Station station);

	List<Station> getAllStationData();

	void deleteStationById(int employeeId);
	
	boolean isExistsByEmployeeId(int employeeId);
	
	boolean isExistsEmployee(int employeeId, String station);
	
	List<Station> getCareerProfileByStation(String station);
	
	void deleteEmployeeFromStation(int employeeId, String station);
	
	int countEmployeeByStation(String station);

}
