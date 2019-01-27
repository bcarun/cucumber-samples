package org.arun.cucumber.sharingstate;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
                 plugin = {"json:target/cucumber-report.json",
                           "pretty:target/cucumber-pretty.txt"},
                 glue = {"org.arun.cucumber.sharingstate.config",
                         "org.arun.cucumber.sharingstate.stepdefs"})
public class CucumberTest {}
