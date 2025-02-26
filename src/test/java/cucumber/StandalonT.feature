@tag
Feature: purchase the order from Ecommerce Website
  I want to use this template for my feature file
  Background:
    Given I landed on Ecommerce Page
 @Regression
  Scenario Outline: Positive Test of Submitting the order
   Given Login with username<email>and password<pasword1>
    When I add product<prodectname> to cart
    And checkout<prodectname>the sumbit order
    Then "THANKYOU FOR THE ORDER."message is displayed on the conformation
    Examples:
      | email                | pasword1  | prodectname              |
      | suhanya2022@mail.com | Testing15 | IPHONE 13 PRO |
