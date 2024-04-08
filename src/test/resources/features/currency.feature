Feature: Currency
  @currency
  Scenario Outline: check the error messages in the basket after updating the country switcher
    Given the user is on the Fortnums and Mason homepage
    And the user click on country link
    And the user select the Non EU country switcher <country>
    And the user validate his choose go to PLP page
    Then the user check the chosen country
    And the user check the chosen currency
    #Then the chosen country should be the same as the country selected
    And the user click on shp now button
    And the user add product to bag
    Then a pop-up is displayed
    When the user click to bag icon
    And an error text is displayed on the bag
    Examples:
      | country   |
      | Australia |