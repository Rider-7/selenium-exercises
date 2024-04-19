package com.selflearning.selenium.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OffersPage extends BasePage {

  private By searchBarLocator = By.id("search-field");
  
  private By getProductRowLocator(String productName) {
    return By.xpath(String.format("//table/tbody/tr[contains(., %s)]", productName));
  }

  public OffersPage(WebDriver driver, Logger log) {
    super(driver, log, "https://rahulshettyacademy.com/seleniumPractise/#/offers");
  }

  public void typeIntoSearchBar(String text) {
    waitForVisibilityofWebElement(searchBarLocator, null);
    type(text, searchBarLocator);
  }

    /** Checks whether a given product name (case-sensitive) is visible on the page. Returns true if any match is found, otherwise returns false */
  public boolean isProductVisible(String productName) {
    List<WebElement> list = findAll(getProductRowLocator(productName));
    if (list.size() > 0) return true;
    return false;
  }

}
