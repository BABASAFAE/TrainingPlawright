@Feature: Change country for shopping

@ChangeCountryForShopping
  Scenario Outline: Change country for shopping and verify on PLP page
    Given the user is on the Fortnums and Mason homepage
    When the user selects the Non EU country switcher <country>
    And the user selects the new country for shopping <newCountry>
    Then the error message is displayed after updating the country
    And the header displays the updated country and currency
    When the user accesses the country and currency switcher
    And chooses another country <newCountry> and currency <newCurrency>
    And validates the selection
    And navigates to the PLP page
    Then the PLP page displays the chosen country "<newCountry>" and currency "<newCurrency>"
    And test for git 
Examples:
| country        | newCountry | newCurrency           |
| United Kingdom | Australia  | United States / $ USD |