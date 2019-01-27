package org.arun.cucumber.sharingstate.dto;

import lombok.Data;

@Data
public class Contact {

  private Long id;
  private String type;
  private String phone;
  private String email;
}
