package com.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.entity.EmployeeCareerProfile;

@Repository
public interface EmployeeCareerProfileRepository extends JpaRepository<EmployeeCareerProfile, Integer> {

	/*
	 * Native Query for retrieving employee_id using primary id in relation with
	 * table employee and table job_description.
	 */
	@Query(value = "SELECT employee_id FROM job_description t1 JOIN employee "
			+ "t2 ON t1.id = t2.e_id WHERE t1.id = :id", nativeQuery = true)
	public int getEmployeeIdById(@Param("id") final int id);

	@Query(value = "SELECT DISTINCT station FROM job_description", nativeQuery = true)
	List<String> getDistinctStation();

	@Transactional
	List<EmployeeCareerProfile> findByStation(String station);
}
