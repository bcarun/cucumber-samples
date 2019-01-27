package org.arun.cucumber.sharingstate.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDate joinDate;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ContactEntity> contacts;
}
