

Feature: Customer functionality

  Background:
	  Scenario: Login to no commerce
    When User launch URL 
    And  User enter valid username and password
    When User click on Login 
    Then  User able to login successfully and verify home page title
	

  Scenario: Adding a new customer
    When User clicks on customer Menu
    And Click on customer SubMenu Item
    When Click on Add new customer
    Then User can see customer page
    When User enter customer informaton
    When User click on save button
    Then User can see confirmation message "The new customer ahs been added successfully"
    And Close the browser
    
    
 