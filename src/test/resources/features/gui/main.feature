@gui
Feature: Login tests

  Background:
    Given init browser
    * open login page

  @PositiveScenario
  Scenario: Log in with correct user credentials
    When user "standard_user" with password "secret_sauce" log in
    Then products page should be displayed

  @NegativeScenario
  Scenario: Log in with incorrect user credentials
    When user "unknown_user" with password "unknown_password" log in
    Then an error message for unknown user should be displayed

  @NegativeScenario
  Scenario: Log in with locked out user credentials
    When user "locked_out_user" with password "secret_sauce" log in
    Then an error message for locked out user should be displayed

  Scenario: Specially falling test for screenshot feature
    When user "standard_user" with password "secret_sauce" log in
    And adds "product" to cart
    Then test should fail and take a screenshot
