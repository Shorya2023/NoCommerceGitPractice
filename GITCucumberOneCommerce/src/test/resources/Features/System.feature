

Feature: System functionality

  Background:
	  Scenario: Login to no commerce
    When User launch URL 
    And  User enter valid username and password
    When User click on Login 
    Then  User able to login successfully and verify home page title
	

  Scenario: verify server local time inside system page
    When User clicks on System Menu
    And 	Click on System SubMenu Item
    When 	User click on save button
    Then 	User can see server local time"
    And 	Close the browser
    
    
 