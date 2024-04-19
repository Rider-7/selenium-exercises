package com.selflearning.selenium;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.selflearning.selenium.pages.CheckoutPage;
import com.selflearning.selenium.pages.LandingPage;
import com.selflearning.selenium.pages.OffersPage;

public class PageObjectManager {

  private LandingPage landingPage;
  private OffersPage offersPage;
  private CheckoutPage checkoutPage;

  public PageObjectManager(WebDriver driver, Logger log) {
    this.landingPage = new LandingPage(driver, log);
    this.offersPage = new OffersPage(driver, log);
    this.checkoutPage = new CheckoutPage(driver, log);
  }

  public LandingPage getLandingPage() {
    return landingPage;
  }

  public OffersPage getOffersPage() {
    return offersPage;
  }

  public CheckoutPage getCheckoutPage() {
    return checkoutPage;
  }
}
