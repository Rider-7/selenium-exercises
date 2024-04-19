package com.selflearning.cucumber.stepdefinitions;

import com.selflearning.cucumber.utilities.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
    private TestContext testContext;
  
  public Hooks(TestContext testContext) {
    this.testContext = testContext;
  }

  @After
  public void closeBrowser() {
    testContext.teardown();
  }

  @AfterStep
  public void takeScreenshotOfFailure(Scenario scenario) {
    if (scenario.isFailed()) {
      scenario.attach(testContext.getScreenshotAsBytes(), "image/png", "screenshot");
    }
  }
}
