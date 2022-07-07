package stepDefinitions;

import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginStepDefinitions {

	public LoginPage loginPage;
	
	@Before("@Login")
	public void beforeScenarios() throws IOException {	
//		Setting up the driver
		if(loginPage == null) {
			loginPage = new LoginPage();
		}
	}
	
	@Given("I am in the login page ready for write the credentials")
	public void i_am_in_the_login_page_ready_for_write_the_credentials() { 
//		Getting and loading the login page
		loginPage.loadLoginPage();
	}

	@When("I put {string} in the Username field")
	public void i_put_in_the_username_field(String username) {
//		Inserting username for log in process
		loginPage.insertUsername(username);
	}

	@When("I put {string} in the Password field")
	public void i_put_in_the_password_field(String password) {
//		Inserting password for log in process
		loginPage.insertPassword(password);
	}
	
	@When("I press login button")
	public void i_press_login_button() {
//		Clicking on login button
		loginPage.pressLoginBtn();
	}
	
	@Then("I am in the dashboard page")
	public void i_am_in_the_dashboard_page() {
//		Getting the actual url in order to compare and validate the right login process
		String actualPage = loginPage.getCurrentUrl();
	    Assert.assertEquals(actualPage, loginPage.getDashboardLink());
	}
	
	@Then("I receive advice about issue with credentials")
	public void i_receive_advice_about_issue_with_credentials() {
//		Validating if exist advice for wrong log in process
		Assert.assertEquals(loginPage.validateAdvice(), true);
	}
	
	@After("@Login")
	public void afterScenarios() {
//		Closing the driver after the test
		loginPage.quit();
	}
	
}
