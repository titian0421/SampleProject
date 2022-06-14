#Author: Cristian Ramiro Jimenez Molina cj00856208@techmahindra.com
#Project: Sample project with the page: https://opensource-demo.orangehrmlive.com/

@Logout
Feature: Logout from the account

	Scenario: Log out from the welcome menu options
		Given I am in the Dashboard page and logged into my account
		When I go to the welcome options
		And I click the Logout option
		Then I am in the Login page
