package com.arun.cucumber.hello.employee;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone {

  @NotNull
  private Long id;

  @NotEmpty
  private String type;

  @NotEmpty
  private String isdCode;

  @NotEmpty
  private String phoneNumber;

  private String extension;
}
