package org.arun.cucumber.crudusingdatatable;

import cucumber.api.java.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudUsingDatatableApplicationTests {

  private static final Logger LOG = LoggerFactory.getLogger(CrudUsingDatatableApplicationTests.class);

  @Test
  public void contextLoads() {
  }

  @Before
  public void initCucumber() {
    LOG.info("------------------Cucumber Initialized Successfully--------------------");
  }

}
