Feature: Webtable app login
  User Story: User should be able to login webtable application

  @webtableParam
  Scenario: Login scenario with valid credentials
    Given user is on the login page of webtable app
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains orders

  @webtableTwoParams
  Scenario: Login with two params
    Given user is on the login page of webtable app
    When user enters username "Test" password "Tester" and logs in
    Then user should see url contains orders
