Feature: product

  @Product
  Scenario Outline: Add Product to basket
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country>
    When the user hover the Gategory "<category>"
    And the user choose the sub Category "<subcategory>"
    Then the user choose the product "<product>"
    And  the user add product to bag "<product>"
    And the user check his basket
    Then the prices should be consistent
    Examples:
      | country        | category | subcategory | product     |
      | United Kingdom | Biscuits | chocalte    | Toffolossus Biscuits, 600g |
  @Quantity
  Scenario Outline: Add Product to basket
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country>
    When the user hover the Gategory "<category>"
    And the user choose the sub Category "<subcategory>"
    Then the user choose the product "<product>"
    And  the user add product to bag "<product>"
    And the user check his basket
    And the user add quantity
    Then the price should be equal to the total
    Examples:
      | country        | category | subcategory | product     |
      | United Kingdom | Biscuits | chocalte    | Toffolossus Biscuits, 600g |







