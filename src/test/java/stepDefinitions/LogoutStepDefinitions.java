package stepDefinitions;

import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogoutPage;

public class LogoutStepDefinitions {
	
	public LogoutPage logoutPage;
	public String username = "Admin";
	public String password = "admin123";

	
	@Before("@Logout")
	public void beforeScenarios() throws IOException {
//		Setting up the driver
		if(logoutPage == null) {
			logoutPage = new LogoutPage();
		}
	}
	
	@Given("I am in the Dashboard page and logged into my account")
	public void i_am_in_the_dashboard_page_and_logged_into_my_account() {
		logoutPage.loginWithCredentials();
	}
	
	@When("I go to the welcome options")
	public void i_go_to_the_welcome_options() {
	    logoutPage.showWelcomeOptions();
	}

	@When("I click the Logout option")
	public void i_click_the_logout_option() {
		logoutPage.logout();
	}

	@Then("I am in the Login page")
	public void i_am_in_the_login_page() {
		Assert.assertEquals(logoutPage.getCurrentUrl(), logoutPage.getLoginLink());
	}
	
	@After("@Logout")
	public void afterScenarios() {
//		Closing the driver after the test
		logoutPage.quit();
	}
	
}
