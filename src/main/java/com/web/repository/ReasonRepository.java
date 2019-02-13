package com.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.entity.Reason;

public interface ReasonRepository extends JpaRepository<Reason, Integer> {

	@Transactional
	List<Reason> findByEmployeeId(int employeeId);

	@Query(value="SELECT * FROM logout_employee t1 JOIN reason t2 ON "
			+ "t1.employee_id = t2.employee_id AND t1.date_time = t2.local_date_time "
			+ "WHERE t1.id = :id", nativeQuery = true)
	List<Reason> getReasonStatusById(@Param("id") final int id);
}
