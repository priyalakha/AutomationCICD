
@tag
Feature: Error Validation
  I want to use this template for my feature file

  

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                   | password      |
      | riyalakha003@gmail.com | Priyalakha@11 |
