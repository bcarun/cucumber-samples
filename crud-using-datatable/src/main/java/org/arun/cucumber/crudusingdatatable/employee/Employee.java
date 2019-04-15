package org.arun.cucumber.crudusingdatatable.employee;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.CreateEmployee;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.UpdateEmployee;

@Getter
@Setter
public class Employee {

  @NotNull(groups = {UpdateEmployee.class})
  private Long id;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String firstName;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String lastName;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  public LocalDate dateOfBirth;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  public LocalDate startDate;

  public LocalDate endDate;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String employmentType;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String email;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  private List<Phone> phones;

}
