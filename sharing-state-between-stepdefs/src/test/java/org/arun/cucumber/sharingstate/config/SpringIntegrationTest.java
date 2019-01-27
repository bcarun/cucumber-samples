package org.arun.cucumber.sharingstate.config;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

  private static final Logger LOG = LoggerFactory.getLogger(SpringIntegrationTest.class);

  @Before
  public void setUp() {
    LOG.info("------------- TEST CONTEXT SETUP -------------");
  }

  @After
  public void tearDown() {
    LOG.info("------------- TEST CONTEXT TEAR DOWN -------------");
    TestContext.CONTEXT.reset();
  }

}

