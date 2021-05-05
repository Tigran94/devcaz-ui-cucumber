Feature: I want to test login functionality

  Scenario: I want to login with correct credentials
    Given I go to main page
    And I login as "admin1" with password "[9k<k8^z!+$$GkuP"
    Then I have successfully logged in