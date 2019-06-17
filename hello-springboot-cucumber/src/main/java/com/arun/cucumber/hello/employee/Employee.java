package com.arun.cucumber.hello.employee;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

  private Long id;

  @NotEmpty
  private String firstName;

  @NotEmpty
  private String lastName;

  @NotNull
  public LocalDate dateOfBirth;

  @NotNull
  public LocalDate startDate;

  public LocalDate endDate;

  @NotEmpty
  private String employmentType;

  @NotEmpty
  private String email;

  @NotNull
  private List<Phone> phones;

}
