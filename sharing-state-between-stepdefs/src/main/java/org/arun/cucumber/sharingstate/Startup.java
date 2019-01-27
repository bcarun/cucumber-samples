package org.arun.cucumber.sharingstate;

import java.net.URI;
import org.arun.cucumber.sharingstate.dao.EmployeeDao;
import org.arun.cucumber.sharingstate.dto.Employee;
import org.arun.cucumber.sharingstate.entity.EmployeeEntity;
import org.arun.cucumber.sharingstate.mapper.EmployeeMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class Startup {

  public static void main(String[] args) {
    SpringApplication.run(Startup.class, args);
  }

  /* Controller, Service, Dao classes are created in one place to make it easier to read,
  you may have them separate in your application */

  @RestController
  @RequestMapping(path = "/api/v1/employees")
  public static class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
      this.employeeService = employeeService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody Employee employee, UriComponentsBuilder uriComponentsBuilder) {
      Long id = employeeService.create(employee);
      final URI locationUri = uriComponentsBuilder.path("/api/v1/employees/{employee-id}")
          .build(id);

      return ResponseEntity.created(locationUri)
          .build();
    }
  }

  @Service
  public static class EmployeeService {

    private EmployeeDao employeeDao;
    private EmployeeMapper employeeMapper;

    /* Using spring constructor injection */
    public EmployeeService(EmployeeDao employeeDao, EmployeeMapper employeeMapper) {
      this.employeeDao = employeeDao;
      this.employeeMapper = employeeMapper;
    }

    @Transactional
    public Long create(Employee employee) {
      EmployeeEntity employeeEntity = employeeMapper.toEmployeeEntity(employee);
      employeeDao.save(employeeEntity);

      return employeeEntity.getId();
    }
  }

}

