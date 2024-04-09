Feature: Subscription


  @mailing
  Scenario Outline: Verify subscription to the mailing list form
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country>
    And the user has accessed the subscription form
    When the user attempts to subscribe
    And the user selects a country where he lives
    And The user selects what they are most excited to hear about in the world of Fortnum's
    And The user selects a Fortnums product to take to the desert island
    And the user clicks on Sign Up
    Then the user has successfully subscribed
    Examples:
      | country |
      | United Kingdom |