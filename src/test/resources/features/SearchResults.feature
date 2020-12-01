Feature: Search Results
  Agile Story: User should be able to see search results after searching

  @search
  Scenario: User should be able to login as a librarian and see table columns names
    Given User is on landing page
    When User clicks "Users" link
    Then User should see following table columns:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |


    # command +  option + L ==> straightens the pipes