Feature: Screenshot

  Scenario: Taking a screenshot on test failure
    Given init browser
    * open login page
    When user "standard_user" with password "secret_sauce" log in
    And clicks on product "Sauce Labs Backpack" and adds one item to cart
    Then test should fail and take a screenshot