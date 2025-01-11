Feature: User should see his/her account summary

  Background:
    Given User is on the login page
    When User enters the valid credentials
    And User navigates to account page

  @account @smoke
  Scenario: Account summary
    Then User should see account type as "CHECKING"
    And User amount should be greater than zero

  @account @smoke
  Scenario: Transactions Summary
    Then User should see transactions in date descending order if list is not empty