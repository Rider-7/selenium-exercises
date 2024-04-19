package com.selflearning.cucumber.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.selflearning.selenium.BrowserDriverFactory;
import com.selflearning.selenium.PageObjectManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestContext {

  public PageObjectManager pageObjectManager;
  public Map<String, Object> variables;

  private Logger log = LogManager.getLogger();
  private WebDriver driver = new BrowserDriverFactory("chrome", log).createDriver();


  public TestContext() {
    this.pageObjectManager = new PageObjectManager(this.driver, this.log);
    this.variables = new HashMap<String, Object>();
  }

  public void teardown() {
    this.driver.quit();
  }

  public byte[] getScreenshotAsBytes() {
    return ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES);
  }
  
}
