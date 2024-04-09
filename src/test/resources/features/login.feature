Feature: Login

  @Account
  Scenario Outline: login with valid data
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country>
    And the user has accessed the login form
    When the user attempts to login
    Then the user is successfully logged in
    Examples:
      | country        |
      | United Kingdom |
