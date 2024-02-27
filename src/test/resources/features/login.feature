@logIn
Feature: Saucedemo app login feature

  Background: For the scenarios in this feature file, user is expected to be on login page
    Given user is on the saucedemo login page

  @standard_user
  Scenario: Login as a standard user
    When the user enters "standard_user" username
    And the user enters "secret_sauce" password
    Then the user should see the dashboard


  @locked_out_user
  Scenario: Login as a locked out user
    When the user enters "locked_out_user" username
    And the user enters "secret_sauce" password
    Then the user should see the error message