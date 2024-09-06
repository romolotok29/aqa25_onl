Feature: E2E test
  Scenario: Login, add to cart and checkout successfully
    Given init browser
    * open login page
    When user "standard_user" with password "secret_sauce" log in
    * clicks on product "Sauce Labs Backpack" and adds one item to cart
    * moves to shopping cart and proceeds to checkout
    And fills in checkout information and clicks finish button
    Then checkout complete page with successful message and title should be displayed
    Then checkout complete page must have a Back Home button

