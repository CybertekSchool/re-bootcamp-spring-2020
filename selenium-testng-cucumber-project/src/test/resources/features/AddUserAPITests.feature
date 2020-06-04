@smoke @add_user @lib-433
Feature: Add user end point test

  Scenario: add student using add user service
    Given new student is added using the add_user endpoint
    When I login as the new user created using add_user endpoint
    Then "Books" page should be displayed

  Scenario: add student using add user service
    Given new librarian is added using the add_user endpoint
    When I login as the new user created using add_user endpoint
    Then "Dashboard" page should be displayed
