package com.selflearning.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.Logger;

public class BrowserDriverFactory {

  private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
  private String browser;
  private Logger log;

  public BrowserDriverFactory(String browser, Logger log) {
    this.browser = browser;
    this.log = log;
  }

  public WebDriver createDriver() {
    log.info("Creating " + browser + "driver...");
    switch (browser) {
      case "chrome":
        driver.set(new ChromeDriver());
        break;
      case "edge":
        driver.set(new EdgeDriver());
        break;
      case "firefox":
        driver.set(new FirefoxDriver());
        break;
      default:
        log.info("Cannot start " + browser + ". Starting chrome instead...");
        driver.set(new ChromeDriver());
    }
    log.info(browser + " driver created!");
    return driver.get();
  }

}
