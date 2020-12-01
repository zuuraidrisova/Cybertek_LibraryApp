Feature: Login as a librarian to see records
  Agile Story: User should be able to login as librarian and see all records

  @dataTable
  Scenario: Seeing records after logging as a librarian
    Given User is on landing page
    When User clicks "Users" link
    Then Show records default value should be 10
    And Show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |

     # command +  option + L ==> straightens the pipes