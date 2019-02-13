package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.Reason;
import com.web.repository.ReasonRepository;

@Service
public class ReasonServiceImpl implements ReasonService {

	@Autowired
	private ReasonRepository reasonRepo;

	@Override
	public void saveReason(Reason reason) {
		reasonRepo.save(reason);
	}

	@Override
	public List<Reason> findByEmployeeId(int employeeId) {
		return reasonRepo.findByEmployeeId(employeeId);
	}

	@Override
	public List<Reason> getReasonStatusById(int id) {
		return reasonRepo.getReasonStatusById(id);
	}

}
