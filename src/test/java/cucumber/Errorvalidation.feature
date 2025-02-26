@tag
  Feature:Login error validation
    I want to use this template for my feature file
    @Errorvalidation
   Scenario Outline:
     Given I landed on Ecommerce Page
     When Login with username<email>and password<pasword1>
     Then "Incorrect email or password." message is displayed
     Examples:
       | email              | pasword1  |
       | suhanya20@mail.com | Testing15 |