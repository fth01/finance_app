Feature: User should be able to transfer money to selected account

  Background:
    Given User is on the login page
    When User enters the valid credentials
    And User navigates to account page
    And User opens transfer money modal

  @transfer @smoke
  Scenario: Transfer money modal
    Then User should see account name as selected in Sender account dropdown
    And Receiver account should have options
      | Testinium-1 |
      | Testinium-2 |
      | Testinium-3 |
      | Testinium-4 |
      | Testinium-5 |
    And Amount input should be empty
    And Send button should be disabled

  @transfer @smoke
  Scenario Outline: Transfer money to receiver "<receiver>"
    When User selects receiver as "<receiver>"
    And User enters the amount "<amount>"
    And User clicks the send button
    Then Transaction detail "<receiver>", "<amount>" should be added the top of the transactions list
    And User amount should be decreased by "<amount>"
    Examples:
      | receiver    | amount |
      | Testinium-2 | 10000  |
      | Testinium-3 | 15000  |