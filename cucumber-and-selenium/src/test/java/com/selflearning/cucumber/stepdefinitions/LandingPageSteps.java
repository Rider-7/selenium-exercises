package com.selflearning.cucumber.stepdefinitions;

import org.testng.Assert;

import com.selflearning.cucumber.utilities.TestContext;
import com.selflearning.selenium.pages.LandingPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LandingPageSteps {

  private TestContext testContext;

  public LandingPageSteps(TestContext testContext) {
    this.testContext = testContext;
  }

  @Given("that user is on GreenCart Landing page")
  public void that_user_is_on_green_cart_landing_page() {
    LandingPage landingPage = testContext.pageObjectManager.getLandingPage();
    landingPage.openPage();
  }

  @When("user searches for {string} product by typing {string} into search bar on Landing page")
  public void user_searches_for_product_by_typing_into_search_bar_on_landing_page(String product, String text) {
    LandingPage landingPage = testContext.pageObjectManager.getLandingPage();
    landingPage.typeIntoSearchBar(text);
    testContext.variables.put("isProductOnLanding", landingPage.isProductVisible(product));
  }

  @And("user navigates to Offers page by clicking on the 'Top Deals' link")
  public void user_clicks_on_the_top_deals_link() {
    LandingPage landingPage = testContext.pageObjectManager.getLandingPage();
    landingPage.clickOnTopDealsLink().focusPage();
  }

  @Then("{string} product must display on both pages")
  public void product_must_exist_on_both_pages(String product) {
      Assert.assertTrue((Boolean) testContext.variables.get("isProductOnLanding"), product + " is not on Landing page: ");
      Assert.assertTrue((Boolean) testContext.variables.get("isProductOnOffers"), product + " is not on Offers page: ");
  }

  @When("user adds {string} product into cart")
  public void user_adds_product_into_cart(String string) {
    LandingPage landingPage = testContext.pageObjectManager.getLandingPage();
    landingPage.addProductToCart(string);
  }
  @When("user navigates to Checkout page")
  public void user_navigates_to_checkout_page() {
    LandingPage landingPage = testContext.pageObjectManager.getLandingPage();
    landingPage.openCartPreview();
    landingPage.clickOnCartCheckoutButton();
  }
}