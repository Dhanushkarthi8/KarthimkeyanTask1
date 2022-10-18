@Login
Feature: Verifying Trello Login and List Creation

  Scenario Outline: Verifying Trello Login and List Creation
    Given User is on the Trello page
    When User should perform login "<userName>","<password>"
    And User should create a list
    Then User Should Verify Success Message After Logout "https://trello.com/home"

    Examples: 
      | userName                   | password     |
      | dhanushkarthi876@gmail.com | Karthi@87600 |
