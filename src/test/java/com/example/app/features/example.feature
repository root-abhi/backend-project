Feature: Greeting feature
  Scenario: Greet a user
    Given the application is running
    When I greet "World"
    Then I should see "Hello, World!"
