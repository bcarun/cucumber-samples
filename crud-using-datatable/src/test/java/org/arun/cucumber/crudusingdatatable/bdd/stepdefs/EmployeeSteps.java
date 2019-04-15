package org.arun.cucumber.crudusingdatatable.bdd.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.arun.cucumber.crudusingdatatable.employee.Employee;
import org.arun.cucumber.crudusingdatatable.employee.Phone;

/**
 * Step Definition Class for Employee.
 *
 * <p>Uses Java Lambda style step definitions so that we don't need to worry
 * about method naming for each step definition</p>
 */
public class EmployeeSteps extends AbstractSteps implements En {

  public EmployeeSteps() {

    Given("(user wants to create/update )an employee with the following attributes", (DataTable employeeDt) -> {
      testContext().reset();
      List<Employee> employeeList = employeeDt.asList(Employee.class);

      // First row of DataTable has the employee attributes hence calling get(0) method.
      super.testContext()
        .setPayload(employeeList.get(0));
    });

    And("with the following phone numbers", (DataTable phoneDt) -> {
      List<Phone> phoneList = phoneDt.asList(Phone.class);
      super.testContext()
        .getPayload(Employee.class)
        .setPhones(phoneList);
    });

    When("user saves the new employee {string}", (String testContext) -> {
      String createEmployeeUrl = "/v1/employees";

      // AbstractSteps class makes the POST call and stores response in TestContext
      executePost(createEmployeeUrl);
    });

    When("user saves the employee {string}", (String testContext) -> {
      String createEmployeeUrl = "/v1/employees";

      // AbstractSteps class makes the POST call and stores response in TestContext
      executePut(createEmployeeUrl);
    });

    /**
     * This can be moved to a Class named 'CommonSteps.java so that it can be reused.
     */
    Then("the save/get/delete {string}", (String expectedResult) -> {
      Response response = testContext().getResponse();

      switch (expectedResult) {
        case "IS SUCCESSFUL":
          assertThat(response.statusCode()).isIn(200, 201);
          break;
        case "FAILS":
          assertThat(response.statusCode()).isBetween(400, 504);
          break;
        default:
          fail("Unexpected error");
      }
    });

    When("employee already exists", () -> {
      String updateEmployeeUrl = "/v1/employees";
      executePost(updateEmployeeUrl);
    });

    When("user wants to get employee by id {long}", (Long id) -> {
      String getEmployeeByIdUrl = "/v1/employees/" + id;
      executeGet(getEmployeeByIdUrl);
    });

    Then("following employee is returned", (DataTable expectedEmployeeDt) -> {
      Response response = testContext().getResponse();
      List<Employee> actualEmployeeList = Arrays.asList(response.as(Employee.class));

      DataTable actualEmployeeDt = toEmployeeDataTable(actualEmployeeList);
      expectedEmployeeDt.unorderedDiff(actualEmployeeDt);
    });

    Then("following employee phone numbers are returned", (DataTable expectedPhoneDt) -> {
      Response response = testContext().getResponse();
      Employee employee = response.as(Employee.class);
      List<Phone> actualPhoneList = employee.getPhones();

      DataTable actualPhoneDt = toPhoneDataTable(actualPhoneList);
      expectedPhoneDt.unorderedDiff(actualPhoneDt);
    });
    
    When("user wants to delete employee by id {long}", (Long id) -> {
      String deleteEmployeeByIdUrl = "/v1/employees/" + id;
      executeDelete(deleteEmployeeByIdUrl);
    });
  }

  private DataTable toEmployeeDataTable(List<Employee> employeeList) {
    List<List<String>> listOfList = new ArrayList<>();
    listOfList.add(Arrays.asList("id", "firstName", "lastName", "dateOfBirth", "startDate", "employmentType", "email"));

    employeeList.forEach(e -> {
      Long id = e.getId();
      LocalDate dateOfBirth = e.getDateOfBirth();
      LocalDate startDate = e.getStartDate();

      listOfList.add(
        Arrays.asList(id.toString(), e.getFirstName(), e.getLastName(), dateOfBirth.toString(), startDate.toString(), e.getEmploymentType(),
          e.getEmail()));
    });

    return DataTable.create(listOfList);
  }

  private DataTable toPhoneDataTable(List<Phone> phoneList) {
    List<List<String>> listOfList = new ArrayList<>();
    listOfList.add(Arrays.asList("id", "type", "isdCode", "phoneNumber", "extension"));

    phoneList.forEach(e -> {
      Long id = e.getId();
      listOfList.add(Arrays.asList(id.toString(), e.getType(), e.getIsdCode(), e.getPhoneNumber(), e.getExtension()));
    });

    return DataTable.create(listOfList);
  }
}
