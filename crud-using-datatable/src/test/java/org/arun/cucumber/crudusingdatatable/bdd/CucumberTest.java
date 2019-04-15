package org.arun.cucumber.crudusingdatatable.bdd;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * To run cucumber test
 */
@RunWith(CucumberReportRunner.class)
@CucumberOptions(features = "classpath:features", plugin = {"pretty",
                                                            "json:target/cucumber-report.json"})
public class CucumberTest {

}
