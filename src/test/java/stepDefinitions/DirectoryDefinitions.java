package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CommonInstructions;

public class DirectoryDefinitions {

	public CommonInstructions common;
	public String noRecordsMessage; 
	public String searchedUser;
	public String name;
	
	public DirectoryDefinitions(CommonInstructions common) {
		
		this.common = common;
		
	}
	
	@Before("@DirectorySearch")
	public void beforeScenarios() {
		
//		Setting up the driver
		
		WebDriverManager.chromedriver().setup();
		
		common.driver = new ChromeDriver();
		
		common.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@When("I go to the directory module")
	public void i_go_to_the_directory_module() {
	    
//		Going to the directory module
		
		WebElement directoryElement = common.driver.findElement(By.xpath("//a[contains(@id, 'directory')]")); //Getting the directory element
	    
		directoryElement.click();
		
	}

	@When("I insert {string} into the name field")
	public void i_insert_into_the_name_field(String name) {
	    
//		Inserting the searched name into the name field
		
		this.name = name;
		
		WebElement nameElement = common.driver.findElement(By.xpath("//input[@id='searchDirectory_emp_name_empName']")); //Getting the name field element
	    
		nameElement.sendKeys(this.name);
		
	}

	@When("I press the Search button")
	public void i_press_the_search_button() {
	 
//		Clicking on the search button
		
		WebElement buttonElement = common.driver.findElement(By.xpath("//input[@id='searchBtn']")); //Getting the search button element
	    
		buttonElement.click();
		
	}
	
	@When("I press the Reset button")
	public void i_press_the_reset_button() {
	    
//		Clicking on the reset button
		
		WebElement buttonElement = common.driver.findElement(By.xpath("//input[@id='resetBtn']")); //Getting the search button element
	    
		buttonElement.click();
		
	}

	@Then("I see the match")
	public void i_see_the_match() {
	    
//		Getting the results
		
		WebElement resultsElement = common.driver.findElement(By.xpath("//table[@id='resultTable']//b"));
	    
		String userMatch = resultsElement.getText();
		
//		Assert validation
		
		Assert.assertEquals(userMatch, this.name);
		
	}

	@Then("I see the message {string}")
	public void i_see_the_message(String message) {
	    
//		Getting the message
		
		WebElement messageElement = common.driver.findElement(By.xpath("//div[@class='box searchForm']//div[@class='inner']"));
	    
		noRecordsMessage = messageElement.getText();
		
//		Assert validation
		
		Assert.assertEquals(noRecordsMessage, message);
		
	}
	
	@Then("I see empty the name field")
	public void i_see_empty_the_name_field() {
	    
//		Getting the value of the name field
		
		WebElement nameElement = common.driver.findElement(By.xpath("//input[@id='searchDirectory_emp_name_empName']"));
	    
		String nameField = nameElement.getText();
		
//		Assert validation
		
		Assert.assertEquals(nameField, "");
		
	}
	
	@After("@DirectorySearch")
	public void afterScenarios() {
		
//		Closing the driver after the test
		
		common.driver.quit();
		
	}
	
}
