package org.arun.cucumber.crudusingdatatable.employee;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.CreateEmployee;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.UpdateEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class EmployeeService {

  @Autowired
  private EmployeeMapper mapper;

  @Autowired
  private EmployeeDao employeeDao;

  @Transactional
  @Validated(CreateEmployee.class)
  public Long create(@Valid Employee employee) {
    EmployeeEntity employeeEntity = mapper.toEmployeeEntity(employee);
    employeeDao.save(employeeEntity);

    return employeeEntity.getId();
  }

  @Transactional
  @Validated(UpdateEmployee.class)
  public void update(@Valid Employee employee) {
    EmployeeEntity employeeEntity = mapper.toEmployeeEntity(employee);
    employeeDao.save(employeeEntity);
  }

  @Transactional(readOnly = true)
  public Employee getById(@NotNull Long id) {
    EmployeeEntity employeeEntity = employeeDao.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Employee not found for given id"));

    return mapper.toEmployee(employeeEntity);
  }

  @Transactional
  public void deleteById(@NotNull Long id) {
    EmployeeEntity employeeEntity = employeeDao.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Employee not found for given id"));

    employeeDao.delete(employeeEntity);
  }

}
