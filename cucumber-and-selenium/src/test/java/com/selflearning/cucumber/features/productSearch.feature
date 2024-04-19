Feature: Product Search

  Scenario Outline: Product is listed in Landing and Offers page
    Given that user is on GreenCart Landing page
    When user searches for "<product>" product by typing "<search>" into search bar on Landing page
    And user navigates to Offers page by clicking on the 'Top Deals' link
    And user searches for "<product>" product by typing "<search>" into search bar on Offers page
    Then "<product>" product must display on both pages

    Examples:
      | product  | search |
      | Tomato   | tom    |
      | Motorcycle | motor    |

