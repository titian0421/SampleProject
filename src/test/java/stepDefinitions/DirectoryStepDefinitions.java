package stepDefinitions;

import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DirectoryPage;

public class DirectoryStepDefinitions {

	public DirectoryPage directoryPage;
	public String name;
	
	@Before("@DirectorySearch")
	public void beforeScenarios() throws IOException {
//		Setting up the driver
		if(directoryPage == null) {
			directoryPage = new DirectoryPage();
		}
	}
	
	@Given("I am in the Dashboard page and logged")
	public void i_am_in_the_dashboard_page_and_logged() {
		directoryPage.loginWithCredentials();
	}
	
	@When("I go to the directory module")
	public void i_go_to_the_directory_module() {	    
//		Going to the directory module
		directoryPage.goToDirectory();
	}

	@When("I insert {string} into the name field")
	public void i_insert_into_the_name_field(String name) {
//		Inserting the searched name into the name field
		this.name = name;
		directoryPage.inputName(name);
	}

	@When("I press the Search button")
	public void i_press_the_search_button() {	 
//		Clicking on the search button
		directoryPage.search();
	}
	
	@When("I press the Reset button")
	public void i_press_the_reset_button() {	    
//		Clicking on the reset button
		directoryPage.clearResults();
	}

	@Then("I see the match")
	public void i_see_the_match() {	    
//		Getting the results
		Assert.assertEquals(directoryPage.validateResults(), name);
	}

	@Then("I see the message {string}")
	public void i_see_the_message(String message) {
//		Getting the message
		Assert.assertEquals(directoryPage.getMessage(), message);
	}
	
	@Then("I see empty the name field")
	public void i_see_empty_the_name_field() {
//		Getting the value of the name field
		Assert.assertEquals(directoryPage.getNameField(), "");
	}
	
	@After("@DirectorySearch")
	public void afterScenarios() {
//		Closing the driver after the test
		directoryPage.quit();
	}
	
}
