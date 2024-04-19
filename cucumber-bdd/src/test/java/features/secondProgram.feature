Feature: Application Login

  Background:
  When Launching the browser from config variables
  And Entering the Home Page URL of website

  @SmokeTest @Mortgage
  Scenario: User Page Mortgage login
    Given User is on Landing Page
    When User logins into application with "mortgageUser" and password 1234
    Then Home Page is displayed
    And Cards are displayed

  @RegressionTest @Banking
  Scenario: User Page Mortgage login
  Given User is on Landing Page
  When User logins into application with "bankingUser" and password 9876
  Then Home Page is displayed
  And Cards are displayed