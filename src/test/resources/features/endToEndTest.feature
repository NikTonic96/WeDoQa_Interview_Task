@e2e
Feature: End to end test

  @e2e
  Scenario: Complete end to end execution as a user
    Given user is on the saucedemo login page
    And user is logged in
    And the user adds an item from the list to the cart
    And the user should see the cart badge is correctly updated
    And the user opens another item’s "Sauce Labs Fleece Jacket" details page
    And the user adds an item "sauce-labs-fleece-jacket" to the cart
    And opens the cart
    And the correct amount of items are present
    And removes the first item from the cart
    And the user should see the correct amount of items in the cart
    And continues to the Checkout page
    And completes the checkout form
    And completes the order
    Then the order is completed successfully with the displayed message