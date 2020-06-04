@smoke @lib-132 @navigation
Feature: Page navigation links

  Scenario Outline: Go go <page>
    Given I am on the login page
    And I login to application as a librarian
    When I click on "<link>" link
    Then "<page>" page should be displayed

    Examples:
      | link      | page      |
      | Books     | books     |
      | Dashboard | dashboard |
      | Users     | users     |
