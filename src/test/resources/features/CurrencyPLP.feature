Feature: CurrencyPLP
  @currencyPLP
  Scenario Outline: Check the currency and the country chosenon the PLP
    Given the user is on the Fortnums and Mason homepage
    And the user click on country link
    And the user select the Non EU country switcher <country>
    And the user validate his choose go to PLP page
    Then the chosen country should be the same as the country selected
    And the chosen currency should be the same as the currency selected
    Examples:
      | country       |
      | United States |