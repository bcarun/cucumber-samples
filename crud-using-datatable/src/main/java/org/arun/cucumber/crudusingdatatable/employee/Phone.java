package org.arun.cucumber.crudusingdatatable.employee;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.CreateEmployee;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.UpdateEmployee;

@Getter
@Setter
public class Phone {
  @NotNull(groups = CreateEmployee.class)
  private Long id;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String type;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String isdCode;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String phoneNumber;

  private String extension;
}
