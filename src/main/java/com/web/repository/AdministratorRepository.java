package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

}
