package org.arun.cucumber.crudusingdatatable.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<EmployeeEntity, Long> {}
