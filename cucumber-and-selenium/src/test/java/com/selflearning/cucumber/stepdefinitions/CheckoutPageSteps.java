package com.selflearning.cucumber.stepdefinitions;

import org.testng.Assert;

import com.selflearning.cucumber.utilities.TestContext;
import com.selflearning.selenium.pages.CheckoutPage;

import io.cucumber.java.en.Then;

public class CheckoutPageSteps {

  private TestContext testContext;

  public CheckoutPageSteps(TestContext testContext) {
    this.testContext = testContext;
  }

  @Then("{string} product must be listed on Checkout Page")
  public void product_must_be_listed_on_checkout_page(String product) {
    CheckoutPage checkoutPage = testContext.pageObjectManager.getCheckoutPage();
    Assert.assertTrue(checkoutPage.isProductVisible(product),
        "Added product " + product + " is not on checkout page: ");
  }

}
