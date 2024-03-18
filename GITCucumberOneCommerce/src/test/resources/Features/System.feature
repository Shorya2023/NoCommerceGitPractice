

Feature: System functionality

  Background:
	  Scenario: Login to no commerce
    When User launch URL 
    And  User enter valid username and password
    When User click on Login 
    Then  User able to login successfully and verify home page title
	

  Scenario: verify server local time inside system page
    When User clicks on System Menu
    When 	Click on System SubMenu Item
    Then 	Verify server local time todays date
    And 	Close the browser
    
    
 