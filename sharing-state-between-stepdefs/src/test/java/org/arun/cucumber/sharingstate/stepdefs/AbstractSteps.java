package org.arun.cucumber.sharingstate.stepdefs;

import static org.arun.cucumber.sharingstate.config.TestContext.CONTEXT;

import org.arun.cucumber.sharingstate.config.TestContext;
import org.springframework.boot.web.server.LocalServerPort;

public abstract class AbstractSteps {

  @LocalServerPort
  private int port;

  public String baseUrl() {
    return "http://localhost:" + port;
  }

  public TestContext testContext() {
    return CONTEXT;
  }
}
