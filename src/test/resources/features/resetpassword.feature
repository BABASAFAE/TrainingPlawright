Feature: Reset_Password


  @reset
  Scenario Outline: Verify subscription to the mailing list form
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country>
    And the user has accessed the login form
    When the user clicks button Forgotten the password
    And The user inserts an email valid
    And The user clicks button Reset Password
    Then the user has successfully resert his password
    And the user accesses the Yopmail website
    And the user logs in with the email used for password reset
    And the user retrieves the latest email
    And the user inserts a new password and confirms it
    And the user sees a popup confirming that the password has been successfully changed
    And the user logs in with the new password
    Then the user is successfully logged in
    And the user successfully accesses their account

    Examples:
      | country |
      | United Kingdom |