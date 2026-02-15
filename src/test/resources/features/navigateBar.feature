Feature: HomePage
@TestHomeWork
  Scenario: User click on navigate bar links
    Given User launches Chrome browser
    When User opens ilcarro HomePage
    Then User verifies that 5 links are present in the navigation bar:
      | Search           |
      | Let the car Work |
      | Terms of use     |
      | Login            |
      | Registration     |
    And User closes browser

