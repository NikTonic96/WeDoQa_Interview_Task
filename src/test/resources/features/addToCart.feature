@addToCart
Feature: Saucedemo add to cart

  Background: For the scenarios in this feature file, user is expected to be logged in
    Given user is logged in

  Scenario: user adds single item to cart
    When the user adds an item "sauce-labs-backpack" to the cart
    Then the user should see the cart badge is correctly updated

  Scenario: user adds single item to cart
    When the user opens another item’s "Sauce Labs Fleece Jacket" details page
    And the user adds an item "sauce-labs-fleece-jacket" to the cart
    And opens the cart
    Then the user should see the cart is correctly updated

  Scenario: changing item amount in cart
    When the user adds an another item from the list to the cart
    And opens the cart
    And removes the first item from the cart
    Then the user should see the correct amount of items in the cart

  Scenario: Verify the correct items in the cart
    When the user adds an item from the list to the cart
    And opens another item’s details page
    And adds the item to the cart
    And opens the cart
    Then the correct amount of items are present