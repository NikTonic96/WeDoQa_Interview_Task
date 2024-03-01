@checkout
Feature: Checkout

  Background: For the scenarios in this feature file, user is expected to be logged in and has an item in the cart
    Given user is logged in
    When the user adds an item from the list to the cart

  Scenario: Checkout
    And opens the cart
    And continues to the Checkout page
    And completes the checkout form
    And completes the order
    Then the order is completed successfully with the displayed message