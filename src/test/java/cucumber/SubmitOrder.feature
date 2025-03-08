
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file


	Background:
	Given I landed on Ecommerce Page
  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Login with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                   | password      | productName |
      | riyalakha003@gmail.com | Priyalakha@12 | ZARA COAT 3 | 
      
