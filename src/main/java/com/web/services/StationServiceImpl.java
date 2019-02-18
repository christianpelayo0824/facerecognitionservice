package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.Station;
import com.web.repository.StationRepository;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private StationRepository stationRepo;

	@Override
	public void saveStation(Station station) {
		stationRepo.save(station);
	}

	@Override
	public List<Station> getAllStationData() {
		return stationRepo.findAll();
	}

	@Override
	public void deleteStationById(int employeeId) {
		stationRepo.deleteById(employeeId);
	}

	@Override
	public boolean isExistsByEmployeeId(int employeeId) {
		return stationRepo.existsByEmployeeId(employeeId);
	}

	@Override
	public boolean isExistsEmployee(int employeeId, String station) {
		return stationRepo.existsEmployee(employeeId, station);
	}

	@Override
	public List<Station> getCareerProfileByStation(String station) {
		return stationRepo.findByEmployeeByStation(station);
	}

	@Override
	public void deleteEmployeeFromStation(int employeeId, String station) {
		stationRepo.deleteEmployeeFromStation(employeeId, station);
		
	}

	@Override
	public int countEmployeeByStation(String station) {
		return stationRepo.countEmployeeByStation(station);
	}

}
