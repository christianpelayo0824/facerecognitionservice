package com.web.services;

import java.util.List;

import com.web.entity.Reason;

public interface ReasonService {

	void saveReason(Reason reason);

	List<Reason> findByEmployeeId(int employeeId);
	
	List<Reason> getReasonStatusById(int id);
}
