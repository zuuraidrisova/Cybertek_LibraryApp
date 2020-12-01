@loginWithParameters
Feature: Login with different parameters
  Agile Story: Different Users should be able to login using respective credentials

  Background: User is on login page
    Given I am on a login page

  Scenario: User should be able to login
    When User enters "librarian13@library" into username
    And User enters "9rf6axdD" into password
    And User clicks to signIn button
    Then Dashboard should be displayed

  Scenario: User should be able to login
    When User enters "librarian14@library" into username
    And User enters "87x8afWY" into password
    And User clicks to signIn button
    Then there should be 2320 users

  Scenario: User should be able to login
    When User enters "librarian43@library" into username
    And User enters "np6AxVIh" into password
    And User clicks to signIn button
    Then User should see 1304 borrowed books

    @wip
  Scenario: Login as librarian in the same line
      When User enters "librarian43@library" and "np6AxVIh"
      And User clicks to signIn button
      Then User should see 1304 borrowed books