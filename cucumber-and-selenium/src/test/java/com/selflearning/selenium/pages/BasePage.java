package com.selflearning.selenium.pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

abstract class BasePage {

  protected WebDriver driver;
  protected Logger log;
  protected String url;

  public BasePage(WebDriver driver, Logger log, String url) {
    this.driver = driver;
    this.log = log;
    this.url = url;
  }

  /** Wait for specific ExpectedCondition<WebElement> for the given Duration */
  private boolean waitForWebElement(ExpectedCondition<WebElement> condition, Duration timeout) {
    timeout = timeout != null ? timeout : Duration.ofSeconds(5);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    if (wait.until(condition) != null)
      return true;
    return false;
  }
  /** Opens a page given by a URL and maximises it */
  public void openPage() {
    driver.get(url);
    driver.manage().window().maximize();
  }

  /** Closes the page given by a URL */
  public void closePage() {
    switchToWindowWithUrl(url);
    driver.close();
  }

  /** Focuses on the page given by a URL */
  public void focusPage() {
    switchToWindowWithUrl(url);
  }

  /** Finds and returns the first WebElement located by a By */
  protected WebElement find(By locator) {
    return driver.findElement(locator);
  }

  /** Finds and returns all WebElements located by a By */
  protected List<WebElement> findAll(By locator) {
    return driver.findElements(locator);
  }

  /** Types text into a WebElement located by a By */
  protected void type(String text, By locator) {
    find(locator).sendKeys(text);
  }

  /** Waits for a WebElement specified by a By to be visible for the given Duration */
  protected void waitForVisibilityofWebElement(By locator, Duration timeout) {
    waitForWebElement(ExpectedConditions.visibilityOfElementLocated(locator), timeout);
  }

  /** Switch from the current window to the window with the given title */
  protected void switchToWindowWithUrl(String expectedUrl) {
    String firstWindow = driver.getWindowHandle();

    Set<String> allWindows = driver.getWindowHandles();
    Iterator<String> windowsIterator = allWindows.iterator();

    while (windowsIterator.hasNext()) {
      String windowHandle = windowsIterator.next().toString();
      if (!windowHandle.equals(firstWindow)) {
        driver.switchTo().window(windowHandle);
        if (getCurrentPageUrl().equals(expectedUrl))
          break;
      }
    }
  }

  /** Returns the current page's URL */
  protected String getCurrentPageUrl() {
    return driver.getCurrentUrl();
  }
}
