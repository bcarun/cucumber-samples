package org.arun.cucumber.sharingstate.stepdefs;

import static io.restassured.RestAssured.given;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;
import org.arun.cucumber.sharingstate.dto.Contact;
import org.arun.cucumber.sharingstate.dto.Employee;

public class EmployeeSteps extends AbstractSteps implements En {

  public EmployeeSteps() {
    Given("user wants to create/update a employee with the following attributes", (DataTable employeeDt) -> {
      List<Employee> employees = employeeDt.asList(Employee.class);
      Employee employee = employees.get(0);

      testContext().setPayload(employee);
    });

    Given("with the following contacts of employee", (DataTable contactDt) -> {
      List<Contact> contacts = contactDt.asList(Contact.class);

      testContext().getPayload(Employee.class)
          .setContacts(contacts);
    });

    When("the user saves new employee", () -> {
      final String createEmployeeUrl = baseUrl() + "/api/v1/employees";

      /* Calling REST endpoint, Saving Response to testContext, Logging Response
       can be made generic and moved to AbstractSteps class */
      final Response response = given().log()
          .all()
          .when()
          .contentType(ContentType.JSON)
          .body(testContext().getPayload())
          .post(createEmployeeUrl)
          .andReturn();

      testContext().setResponse(response);

      response.then()
          .log()
          .all();
    });
  }
}
