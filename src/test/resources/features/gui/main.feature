@gui
Feature: Parametrized tests

  Background:
    Given init browser
    * open login page

  @smoke
  Scenario: Log in with correct user credentials
    When user "standard_user" with password "secret_sauce" log in
    Then products page should be displayed

  @regression
  Scenario: Log in with locked out user credentials
    When user "locked_out_user" with password "secret_sauce" log in
    Then an error message for locked out user should be displayed

    Scenario: Log in with incorrect user credentials
      When user "unknown_user" with password "unknown_password" log in
      Then an error message for unknown user should be displayed
