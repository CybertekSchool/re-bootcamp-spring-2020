@regression @lib-324
Feature: Book information

  @db
  Scenario: Verify book information with db
    Given I am on the login page
    And I login to application as a librarian
    And I navigate to "Books" page
    When I open book The kite runner
    Then book information must match the database for The kite runner

  @db
  Scenario: Book categories validation
    Given I am on the login page
    And I login to application as a librarian
    When I navigate to "Books" page
    Then book categories must match book_categories table from db