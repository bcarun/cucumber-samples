package org.arun.cucumber.crudusingdatatable.employee;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  EmployeeEntity toEmployeeEntity(Employee employee);

  Employee toEmployee(EmployeeEntity employeeEntity);

  PhoneEntity toPhoneEntity(Phone phone);

  Phone toPhone(PhoneEntity phoneEntity);
}
