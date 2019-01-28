package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.Reason;

public interface ReasonRepository extends JpaRepository<Reason, Integer> {

}
