#Author: Cristian Ramiro Jimenez Molina cj00856208@techmahindra.com
#Project: Sample project with the page: https://opensource-demo.orangehrmlive.com/

@Login
Feature: Login into the web page

	@RightLogin
  Scenario: Try to login with the right credentials
    Given I am in the login page ready for write the credentials
    When I put "Admin" in the Username field
    And I put "admin123" in the Password field
    And I press login button
    Then I am in the dashboard page
    
	@WrongLogin
	Scenario: Try to login with empty username field
		Given I am in the login page ready for write the credentials
    When I put "admin123" in the Password field
    And I press login button
    Then I receive advice about issue with credentials
 
	@WrongLogin
    Scenario: Try to login with empty password field
		Given I am in the login page ready for write the credentials
    When I put "Admin" in the Username field
    And I press login button
    Then I receive advice about issue with credentials

	@WrongLogin
  Scenario Outline: Try to login with the wrong credentials
    Given I am in the login page ready for write the credentials
    When I put <Username> in the Username field
    And I put <Password> in the Password field
    And I press login button
    Then I receive advice about issue with credentials
    
    Examples:
    | Username | Password |
    | "Test1" | "Test1" |
    | "Test2" | "Test2" |
    | "Test3" | "Test3" |
    | "Test4" | "Test4" |
