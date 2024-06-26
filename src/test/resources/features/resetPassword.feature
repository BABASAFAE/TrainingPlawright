Feature: Reset Password

  @Reset
  Scenario Outline: Reset password
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country>
    And the user has accessed the login form
    When the user attempts to reset the password
    And the user inserts a valid email and clicks the reset button
    Then the user should see a popup message indicating that an email has been sent for resetting the password
    And the user accesses the Yopmail website
    And the user logs in with the email used for password reset
    And the user retrieves the latest email
    And the user inserts a new password and confirms it
    And the user sees a popup confirming that the password has been successfully changed
    Then the user logs in with the new password
    And the user sees a popup confirming that they have successfully logged in
    And the user successfully accesses their account
    Examples:
      | country        |
      | United Kingdom |

