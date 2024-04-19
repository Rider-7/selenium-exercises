Feature: Application Login
  # # Using Regular Expression to match parameters
  # Scenario: Admin Page default login
  #   Given User is on Landing Page
  #   When User logins into application with admin and password 1234
  #   Then Home Page is displayed
  #   And Cards are displayed
  # Using Cucumber Expression to match parameters

  Background:
  Given Setup the entries in database
  When Launching the browser from config variables
  And Entering the Home Page URL of website

  @SmokeTest 
  Scenario: User Page default login
    Given User is on Landing Page
    When User logins into application with "user" and password 9532
    Then Home Page is displayed
    And Cards are displayed

  @SmokeTest @RegressionTest
  Scenario Outline: User Page default login
    Given User is on Landing Page
    When User logins into application with "<username>" and password <password>
    Then Home Page is displayed
    And Cards are displayed

    Examples: 
      | username   | password |
      | debituser  |      857 |
      | credituser |      123 |

  @MobileTest
  Scenario: User Page sign up
    Given User is on Landing Page
    When User signs-up for application
      | username | dummyname       |
      | password | dummypassword   |
      | email    | dummy@email.com |
      | contact  |         4910292 |
    Then Home Page is displayed
    And Cards are displayed
