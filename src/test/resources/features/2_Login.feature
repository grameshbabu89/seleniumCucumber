Feature: Login and Logout

  @login
  Scenario Outline: As a user, I should be able to Login and Logout to the application
    Given I launch the application
    When I click signIn
    When I login with <LoginName> and <Password>
    Then I logout the application

    Examples: 
      | LoginName    | Password |
      | TestLogin585 | Password |
