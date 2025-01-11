Feature: User should be able to edit his/her account name

  @editAccount @smoke
  Scenario: Editing the account name
    Given User is on the login page
    When User enters the valid credentials
    And User navigates to account page
    And User opens edit account modal
    Then User should see account name in input field
    When User enters the new account name
    And User click update button
    Then User should see new account name under account summary
