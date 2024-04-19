package com.selflearning.selenium.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage {

  private By searchBarLocator = By.className("search-keyword");
  private By topDealsLinkLocator = By.linkText("Top Deals");
  private By cartIconLocator = By.className("cart-icon");
  private By cartCheckoutButtonLocator = By.xpath("//button[contains(., 'PROCEED TO CHECKOUT')]");

  private By getProductCardLocator(String productName) {
    return By.xpath(String.format( "//h4[contains(., %s)]/parent::div", productName));
  }

  private By getProductAddButtonLocator(String productName) {
    return By.xpath(String.format( "//h4[contains(., %s)]/parent::div//button", productName));
  }

  private By getProductIncrementButtonLocator(String productName) {
    return By.xpath(String.format( "//h4[contains(., %s)]/parent::div//a[@class = 'increment']", productName));
  }

  private By getProductDecrementButtonLocator(String productName) {
    return By.xpath(String.format( "//h4[contains(., %s)]/parent::div//a[@class = 'decrement']", productName));
  }

  public LandingPage(WebDriver driver, Logger log) {
    super(driver, log, "https://rahulshettyacademy.com/seleniumPractise/#/");
  }

  public OffersPage clickOnTopDealsLink() {
    find(topDealsLinkLocator).click();
    return new OffersPage(driver, log);
  }

  public CheckoutPage clickOnCartCheckoutButton() {
    find(cartCheckoutButtonLocator).click();
    return new CheckoutPage(driver, log);
  }

  public void typeIntoSearchBar(String text) {
    waitForVisibilityofWebElement(searchBarLocator, null);
    type(text, searchBarLocator);
  }

  public void addProductToCart(String productName) {
    find(getProductAddButtonLocator(productName)).click();
  }

  public void openCartPreview() {
    find(cartIconLocator).click();
  }

  public void incrementProductQuantity(String productName) {
    find(getProductIncrementButtonLocator(productName)).click();
  }

  /** Checks whether a given product name (case-sensitive) is visible on the page. Returns true if any match is found, otherwise returns false */
  public boolean isProductVisible(String productName) {
    List<WebElement> list = findAll(getProductCardLocator(productName));
    if (list.size() > 0) return true;
    return false;
  }

}
