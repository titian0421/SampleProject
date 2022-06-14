#Author: Cristian Ramiro Jimenez Molina cj00856208@techmahindra.com
#Project: Sample project with the page: https://opensource-demo.orangehrmlive.com/

@ForgotPass
Feature: Recover the password because forget it 

	@RightUser
  Scenario: Try to recover the password with existent username
    Given I am in the login page ready for write the credentials
    When I click on Forgot your password? link
    And I put "Admin" in the OrangeHRM Username field
    And I click on Reset Password button
    Then I receive the right message confirmation

	@WrongUser
  Scenario Outline: Try to recover the password with nonexistent username
    Given I am in the login page ready for write the credentials
    When I click on Forgot your password? link
    And I put <Username> in the OrangeHRM Username field
    And I click on Reset Password button
    Then I receive the wrong message confirmation

    Examples: 
      | Username |
      | "User1" |
      | "User2" |
