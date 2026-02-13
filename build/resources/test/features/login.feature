Feature: Login

  @loginPositive
  Scenario: Successful login
    Given User launches Chrome browser
    When User opens ilcarro HomePage
    And User clicks on Login link
    And User enters correct data
    And User cliks on Yalla button
    Then User veriffies Success message is displayed
    And User closes browser

  @wrongPassword
  @navigate
  Scenario Outline: Login with correct email and wrong password
    Given User launches Chrome browser
    When User opens ilcarro HomePage
    And User clicks on Login link
    And User enters correct email and wrong password
      | email   | password   |
      | <email> | <password> |
    And User cliks on Yalla button
    Then User verifies Error message is displayed
    And User closes browser
    Examples:
      | email                | password       |
      | test123456789@gm.com | Test123456789 |
      | test123456789@gm.com | test123456789! |
      | test123456789@gm.com | TEST123456789@ |
      | test123456789@gm.com | тест123456789@ |