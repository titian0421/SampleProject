#Author: Cristian Ramiro Jimenez Molina cj00856208@techmahindra.com
#Project: Sample project with the page: https://opensource-demo.orangehrmlive.com/

@DirectorySearch
Feature: Make a search in the name field of the directory module

	@ExistentUser
	Scenario: Make a search for the existent user
		Given I am in the Dashboard page and logged into my account
		When I go to the directory module
		And I insert "Lisa Andrews" into the name field
		And I press the Search button
		Then I see the match
		
		@UnexistentUser
		Scenario: Make a search for the unexistent user
		Given I am in the Dashboard page and logged into my account
		When I go to the directory module
		And I insert "Cristian Jimenez" into the name field
		And I press the Search button
		Then I see the message "No Records Found"
		
		@ResetSearch
		Scenario: Reset a search from the button Reset
		Given I am in the Dashboard page and logged into my account
		When I go to the directory module
		And I insert "Cristian Jimenez" into the name field
		And I press the Search button
		And I press the Reset button
		Then I see empty the name field
