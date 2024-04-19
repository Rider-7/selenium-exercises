package com.selflearning.cucumber.stepdefinitions;

import com.selflearning.cucumber.utilities.TestContext;
import com.selflearning.selenium.pages.OffersPage;

import io.cucumber.java.en.And;

public class OffersPageSteps {

  private TestContext testContext;
  
  public OffersPageSteps(TestContext testContext) {
    this.testContext = testContext;
  }

  @And("user searches for {string} product by typing {string} into search bar on Offers page")
  public void user_searches_for_product_by_typing_into_search_bar_on_offers_page(String product, String text) {
    OffersPage offersPage = testContext.pageObjectManager.getOffersPage();
    offersPage.typeIntoSearchBar(text);
    testContext.variables.put("isProductOnOffers", offersPage.isProductVisible(product));
  }

}
