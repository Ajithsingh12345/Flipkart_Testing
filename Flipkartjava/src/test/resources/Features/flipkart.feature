
Feature: To verify the Flipkart order  page

Scenario Outline: Place order in  the Flipkart  page Successfully  
  Given user is on Flipkart page
  Then user should search the laptop in search bar
  Then user should get the laptop details
  And user should add the laptop product to the shopping cart
  Then user should verify the item in cart
  When user should click on Proceed to Checkout botton
  And user should quit the browser