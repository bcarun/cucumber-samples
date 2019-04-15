package org.arun.cucumber.crudusingdatatable.bdd;

import cucumber.api.java.Before;
import org.arun.cucumber.crudusingdatatable.CrudUsingDatatableApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

/**
 * Class to use spring application context while running cucumber
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CrudUsingDatatableApplication.class, loader = SpringBootContextLoader.class)
public class CucumberContextConfiguration {

  private static final Logger LOG = LoggerFactory.getLogger(CucumberContextConfiguration.class);

  /**
   * Need this method so the cucumber will recognize this class as glue and load spring context configuration
   */
  @Before
  public void setUp() {
    LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
  }

}
