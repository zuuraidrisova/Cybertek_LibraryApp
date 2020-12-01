@login
Feature: Login
  Agile Story: User should be able to log in as student and librarian.

  Background: User is on login page
    Given User is on login page

  Scenario: User should be able to login as a student
    When User enters correct credentials for student
    Then User should see books


  Scenario: User should be able to login as a librarian
    When User enters correct credentials for librarian
    Then User should see dashboard