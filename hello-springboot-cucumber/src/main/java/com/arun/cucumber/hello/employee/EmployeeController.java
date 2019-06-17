package com.arun.cucumber.hello.employee;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity create(@RequestBody Employee employee, UriComponentsBuilder uriComponentsBuilder) {
    Long id = employeeService.create(employee);

    final URI uri = uriComponentsBuilder.path("/v1/employees/{id}")
        .build(id);

    return ResponseEntity.created(uri)
        .build();
  }

}
