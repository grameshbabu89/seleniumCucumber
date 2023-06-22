Feature: New user registration

  #Email, first name, and login names are randomly generated(Ex:TestLogin123)
  @registration
  Scenario Outline: As a user, I should be able to register as a new customer
    Given I launch the application
    When I click signIn
    Then I click continue to new registration
    When I enter <Email>, <FirstName>, <LoginName>, <Password> and other mandatory fields then submit
    Then I validate the firstName is displayed in the account section
    Then I logout the application

    Examples: 
      | Email     | FirstName | LoginName | Password |
      | testemail | TestfName | TestLogin | Password |
