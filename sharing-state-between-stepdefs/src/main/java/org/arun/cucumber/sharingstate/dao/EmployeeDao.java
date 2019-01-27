package org.arun.cucumber.sharingstate.dao;

import org.arun.cucumber.sharingstate.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {}
