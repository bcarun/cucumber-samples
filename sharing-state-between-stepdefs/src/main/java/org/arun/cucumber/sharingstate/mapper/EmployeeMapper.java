package org.arun.cucumber.sharingstate.mapper;

import org.arun.cucumber.sharingstate.dto.Contact;
import org.arun.cucumber.sharingstate.dto.Employee;
import org.arun.cucumber.sharingstate.entity.ContactEntity;
import org.arun.cucumber.sharingstate.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  /* Mapstruct library uses annotation process to generate the implementation for below methods during compile. */

  EmployeeEntity toEmployeeEntity(Employee employee);

  Employee toEmployee(EmployeeEntity employeeEntity);

  ContactEntity toContactEntity(Contact contact);

  Contact toContact(ContactEntity contactEntity);

}
