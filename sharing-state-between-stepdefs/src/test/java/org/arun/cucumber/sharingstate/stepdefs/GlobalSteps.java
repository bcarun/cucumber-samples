package org.arun.cucumber.sharingstate.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java8.En;
import io.restassured.response.Response;

public class GlobalSteps extends AbstractSteps implements En {

  public GlobalSteps() {

    Then("the save is SUCCESSFUL", () -> {
      /* Method testContext() is from AbstractSteps class */
      final Response response = testContext().getResponse();
      assertThat(response.getStatusCode()).isBetween(200, 201);
    });

    Then("the save FAILS", () -> {
      final Response response = testContext().getResponse();
      assertThat(response.getStatusCode()).isBetween(400, 412);
    });

    Then("the( get| delete) is SUCCESSFUL", () -> {
      final Response response = testContext().getResponse();
      assertThat(response.getStatusCode()).isEqualTo(200);
    });
  }
}
