Feature: Webtable app login
  User Story: User should be able to login webtable application

  @webtableLoginDataTable
  Scenario: login webtable app with using datatable
    Given user is on the login page of webtable app
    When user enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains orders