Feature: I want to test players table
  Scenario: I want to open the players page
    Given I go to main page
    And I login as "admin1" with password "[9k<k8^z!+$$GkuP"
    And I go to the players section
    Then I should redirected to the appropriate section

    Scenario: I want to sort the players table
      Given I go to main page
      And I login as "admin1" with password "[9k<k8^z!+$$GkuP"
      And I redirect to the players section
      And I sort the table by the username
      Then I should assert the table sorting by the username