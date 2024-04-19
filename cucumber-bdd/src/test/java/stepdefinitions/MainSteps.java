package stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {
  @Given("Setup the entries in database")
  public void setup_the_entries_in_database() {
    System.out.println("Setup entries in database");
  }

  @When("Launching the browser from config variables")
  public void launching_the_browser_from_config_variables() {
    System.out.println("Launch browser from config variables");
  }

  @When("Entering the Home Page URL of website")
  public void entering_the_home_page_url_of_website() {
    System.out.println("Enter Home Page URL of website");
  }

  @Given("User is on Landing Page")
  public void user_is_on_landing_page() {
    System.out.println("User is on Landing Page");
  }

  // Using Regular Expression to match parameters
  // @When("^User logins into application with (.+) and password (.+)$")
  // public void user_logins_into_application(String username, int password) {
  // System.out.println("User logins with \"" + username + "\" and password \"" +
  // password + "\"");
  // }

  // Using Cucumber Expression to match parameters
  @When("User logins into application with {string} and password {int}")
  public void user_logins_into_application(String username, int password) {
    System.out.println("User logins with \"" + username + "\" and password \"" + password + "\"");
  }

  @When("User signs-up for application")
  public void user_signups_for_application(Map<String, String> dataList) {
    System.out.println("User signs-up with:");
    dataList.forEach((key, value) -> {
      System.out.println(key + ": " + value);
    });
  }

  @Then("Home Page is displayed")
  public void home_page_is_displayed() {
    System.out.println("User is on Home Page");
  }

  @Then("Cards are displayed")
  public void cards_are_displayed() {
    System.out.println("Cards are displayed");
  }
}
