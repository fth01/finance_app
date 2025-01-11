Feature: User should be able to add money to his/her account

  @addMoney @smoke
  Scenario: Adding money to account
    Given User is on the login page
    When User enters the valid credentials
    And User navigates to account page
    And User opens Add Money modal
    And User enters the card number
    And User enters card holder
    And User enter expiry date
    And User enters ccv number
    And User enters amount "20000"
    And User clicks add button
    Then Transaction detail "20000" should be added the top of the transactions list
    And User amount should be increased by "20000"
