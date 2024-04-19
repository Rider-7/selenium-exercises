package com.selflearning.selenium.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
  
  private By getProductRowLocator(String productName) {
    return By.xpath(String.format("//table/tbody/tr[contains(., %s)]", productName));
  }
  
  public CheckoutPage(WebDriver driver, Logger log) {
    super(driver, log, "https://rahulshettyacademy.com/seleniumPractise/#/cart");
  }

    /** Checks whether a given product name (case-sensitive) is visible on the page. Returns true if any match is found, otherwise returns false */
  public boolean isProductVisible(String productName) {
    List<WebElement> list = findAll(getProductRowLocator(productName));
    if (list.size() > 0) return true;
    return false;
  }

}
