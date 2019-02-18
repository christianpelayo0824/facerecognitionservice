package com.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.entity.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {
	
	@Transactional
	boolean existsByEmployeeId(int employeeId);
	
	@Query("SELECT CASE WHEN count(s) > 0 THEN true ELSE false END FROM Station s "
			+ "WHERE s.employeeId = :employeeId AND s.station = :station")
	boolean existsEmployee(@Param("employeeId") final int employeeId, @Param("station") final String station);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM station WHERE employee_id = :employeeId AND "
			+ "station = :station", nativeQuery = true)
	void deleteEmployeeFromStation(@Param("employeeId") final int employeeId, @Param("station") final String station);

	@Query(value = "SELECT * FROM employee t1 JOIN job_description t2 ON "
			+ "t1.e_id = t2.id JOIN station t3 ON t2.employee_id = t3.employee_id "
			+ "WHERE t3.station = :station", nativeQuery = true)
	List<Station> findByEmployeeByStation(@Param("station") final String station);

	@Query(value = "SELECT COUNT(*) FROM station WHERE station = :station", 
			nativeQuery = true)
	int countEmployeeByStation(@Param("station") final String station);

}
