package stepDefinitions;

import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ForgotPassPage;

public class ForgotPassStepDefinitions {
	
//	public WebDriver driver; //Global driver variable
	public String wrongMessage = "Please contact HR admin in order to reset the password"; //The wrong message we receive when insert nonexistent users in recovery password page
	public ForgotPassPage forgotPassPage;
	
	@Before("@ForgotPass")
	public void beforeScenarios() throws IOException {
//		Setting up the driver	
		if(forgotPassPage == null) {
			forgotPassPage = new ForgotPassPage();
		}
	}
	
	@Given("I am in the login page")
	public void i_am_in_the_login_page() { 
//		Getting and loading the login page
		forgotPassPage.loadLoginPage();
	}
	
	@When("I click on Forgot your password? link")
	public void i_click_on_forgot_your_password_link() {
//		Clicking on forgot your password link
		forgotPassPage.clickForgotPass();
	}

	@When("I put {string} in the OrangeHRM Username field")
	public void i_put_in_the_orange_hrm_username_field(String username) {
//		Inserting the Username that we need recover it's password 
		forgotPassPage.inputUsername(username);
	}

	@When("I click on Reset Password button")
	public void i_click_on_reset_password_button() {
//		Clicking on reset button
		forgotPassPage.clickOnResetBtn();
	}

	@Then("I receive the right message confirmation")
	public void i_receive_the_right_message_confirmation() {
//		Getting the notification message in order to compare and validate the process
		Assert.assertNotEquals(forgotPassPage.getMessageConfirmation(), wrongMessage);
	}

	@Then("I receive the wrong message confirmation")
	public void i_receive_the_wrong_message_confirmation() {
//		Getting the notification message in order to compare and validate the process
		Assert.assertEquals(forgotPassPage.getMessageConfirmation().contains(wrongMessage), true);
	}
	
	@After("@ForgotPass")
	public void afterScenarios() {
//		Closing the driver after the test
		forgotPassPage.quit();
	}

}
