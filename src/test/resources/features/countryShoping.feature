Feature: Display error message for non-deliverable area

  @ChangeCountryForShopping
  Scenario Outline: Display error message for non-deliverable area
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country>
    And the user hovers over the category <category>
    And the user chooses a subcategory <subCategory>
    And the user adds a product to the bag
    And the user go to the bag
    And the user selects the new country <newCountry> for shopping from the the dropdown in basket
    Then the user verifies the selected product with the error message stating that the product can't be delivered to the selected country
    And the header displays the updated country and currency
    When the user accesses the country and currency switcher
    And chooses another country <newCountry> and currency <newCurrency>
    And validates the selection
    And navigates to the PLP page
    Then the PLP page displays the chosen country <newCountry> and currency <newCurrency>
    Examples:
      | country        | newCountry | newCurrency           | category | subCategory |
      | United Kingdom | Australia  | United States / $ USD | Gifts    | Birthdays   |