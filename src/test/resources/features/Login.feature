Feature: User should be able to login

  Background:
    Given User is on the login page

  @login @smoke
  Scenario: Login with valid credentials
    When User enters the valid credentials
    Then Dashboard should be displayed

#  @login
  Scenario Outline: Login with invalid credentials
    When User logs in using "<username>" and "<password>"
    Then User should see error message
    Examples:
      | username    | password    |
      | username123 | password    |
      | username    | password123 |
      |             | password    |
      | username    |             |