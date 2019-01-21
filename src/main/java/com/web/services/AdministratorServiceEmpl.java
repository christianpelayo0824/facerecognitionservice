package com.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.Administrator;
import com.web.repository.AdministratorRepository;

@Service
public class AdministratorServiceEmpl implements AdministratorService {

	@Autowired
	private AdministratorRepository adminRepo;

	@Override
	public Administrator createAdministrator(Administrator admin) {
		return adminRepo.save(admin);
	}

}
