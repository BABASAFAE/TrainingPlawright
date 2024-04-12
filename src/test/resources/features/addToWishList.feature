Feature: addToWishList

  @Add
  Scenario Outline: add to wish list
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country>
    And the user has accessed the login form
    When the user attempts to login
    Then the user is successfully logged in
    And the user delete all product from wish list
    When the user choose the category "<category>"
    Then the user select the subcategory "<subcategory>"
    And the user add the product into wish list
    Then the product is successfully added

    Examples:
      | country |           |category|   |subcategory|
      | United Kingdom |    |Biscuits|   |Caramel    |