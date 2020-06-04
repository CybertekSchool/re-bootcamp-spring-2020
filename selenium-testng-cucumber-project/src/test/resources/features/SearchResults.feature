@lib-2423 @smoke @regression
Feature: Search functionality on the users page

  Background:
    Given new librarian user is available
    And I login as a librarian
    And I click on "Users" link

  Scenario: Search accuracy
    When I search for "test"
    Then table should contain rows with "test"

  Scenario: Table columns names
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |