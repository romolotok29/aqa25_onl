Feature: Negative tests

  Scenario: Log in with locked out user credentials
    Given login page is opened
    When user "locked_out_user" with password "secret_sauce" log in
    Then error with "message" should appear