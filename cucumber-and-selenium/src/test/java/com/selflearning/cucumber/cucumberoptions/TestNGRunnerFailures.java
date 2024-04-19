package com.selflearning.cucumber.cucumberoptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed-scenarios.txt", glue = "com.selflearning.cucumber.stepdefinitions", monochrome = false)
public class TestNGRunnerFailures extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }

}
