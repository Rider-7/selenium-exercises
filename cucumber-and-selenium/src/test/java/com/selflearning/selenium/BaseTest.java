package com.selflearning.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;

public class BaseTest {
  
  protected WebDriver driver;
  protected Logger log;

  // Setup Logger and WebDriver
  @BeforeMethod(alwaysRun = true)
  public void setup(@Optional("chrome") String browser, ITestContext ctx) {
    String testName = ctx.getCurrentXmlTest().getName();
    log = LogManager.getLogger(testName);

    BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
    driver = factory.createDriver();
    driver.manage().window().maximize();
  }

  // Close WebDriver
  @AfterMethod(alwaysRun = true)
  public void teardown() {
    driver.quit();
  }

}
