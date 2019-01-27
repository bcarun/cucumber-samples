package org.arun.cucumber.sharingstate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contact")
public class ContactEntity {

  @Id
  @GeneratedValue
  private Long id;
  private String type;
  private String phone;
  private String email;
}
