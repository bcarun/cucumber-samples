package org.arun.cucumber.crudusingdatatable.employee;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Employee> getById(@PathVariable("id") Long id) {
    Employee employee = employeeService.getById(id);

    return ResponseEntity.ok(employee);
  }

  @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity update(@RequestBody Employee employee) {
    employeeService.update(employee);

    return ResponseEntity.ok()
      .build();
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Employee> deleteById(@PathVariable("id") Long id) {
    employeeService.deleteById(id);

    return ResponseEntity.ok()
      .build();
  }
}
