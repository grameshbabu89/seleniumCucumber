Feature: e2e test scenarios on an e-commerce website

  #Email, first name, and login names are randomly generated(Ex:TestLogin123)
  @e2eRegistration @e2e
  Scenario Outline: As a user, I register for the app as a new customer and place an order.
    Given I launch the application
    When I click signIn
    Then I click continue to new registration
    When I enter <Email>, <FirstName>, <LoginName>, <Password> and other mandatory fields then submit
    Then I validate the firstName is displayed in the account section
    When I click on the <Menu> and select <SubMenu>
    Then I select 2nd product and add to the Cart
    Then I proceed to checkout
    Then I verify the products in the checkout page
    Then I logout the application

    Examples: 
      | Email     | FirstName | LoginName | Password | Menu      | SubMenu |
      | testemail | TestfName | TestLogin | Password | FRAGRANCE | Men     |

  @e2eLogin @e2e
  Scenario Outline: As a user, I login to the app and place an order.
    Given I launch the application
    When I click signIn
    When I login with <LoginName> and <Password>
    When I click on the <Menu> and select <SubMenu>
    Then I select 3th product and add to the Cart
    Then I proceed to checkout
    Then I verify the products in the checkout page
    Then I logout the application

    Examples: 
      | LoginName    | Password | Menu      | SubMenu |
      | TestLogin766 | Password | Fragrance | Women   |
