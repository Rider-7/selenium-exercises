Feature: Shopping Cart

  Scenario Outline: Add product to cart
    Given that user is on GreenCart Landing page
    When user adds "<product>" product into cart
    And user navigates to Checkout page
    Then "<product>" product must be listed on Checkout Page

    Examples:
        | product |
        | Tomato |