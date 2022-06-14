package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CommonInstructions;

public class LoginDefinitions {
	
//	public WebDriver driver; //Global driver variable
	public String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login"; //The login page
	public String dashboardPage = "https://opensource-demo.orangehrmlive.com/index.php/dashboard"; //The right url after correct login
	public CommonInstructions common;
	
	public LoginDefinitions(CommonInstructions common){
		
		this.common = common;
		
	}
	
	@Before("@Login")
	public void beforeScenarios() {
		
//		Setting up the driver
		
		WebDriverManager.chromedriver().setup();
		
		common.driver = new ChromeDriver();
		
		common.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("I am in the login page ready for write the credentials")
	public void i_am_in_the_login_page_ready_for_write_the_credentials() {
		
//		Getting and loading the login page
		
		common.driver.get(loginUrl);
		
	}

	@When("I put {string} in the Username field")
	public void i_put_in_the_username_field(String username) {
		
//		Inserting username for log in process
		
		WebElement usernameElement = common.driver.findElement(By.xpath("//input[contains(@id, 'Username')]")); //Getting the Username field element
	    
		usernameElement.sendKeys(username);
		
	}

	@When("I put {string} in the Password field")
	public void i_put_in_the_password_field(String password) {
		
//		Inserting password for log in process
		
		WebElement passwordElement = common.driver.findElement(By.xpath("//input[contains(@id, 'Password')]")); //Getting the Password field element
		
		passwordElement.sendKeys(password);
		
	}
	
	@When("I press login button")
	public void i_press_login_button() {
	    
//		Clicking on login button
		
		WebElement buttonElement = common.driver.findElement(By.xpath("//input[contains(@id, 'btn')]")); //Getting the login button element
		
		buttonElement.click();
		
	}
	
	@Then("I am in the dashboard page")
	public void i_am_in_the_dashboard_page() {
		
//		Getting the actual url in order to compare and validate the right login process
		
		String actualPage = common.driver.getCurrentUrl();
		
	    Assert.assertEquals(actualPage, dashboardPage);
	    
	}
	
	@Then("I receive advice about issue with credentials")
	public void i_receive_advice_about_issue_with_credentials() {
		
//		Validating if exist advice for wrong log in process
		
		Assert.assertEquals(common.driver.findElement(By.xpath("//div[contains(@id, 'LoginButton')]/span")).isDisplayed(), true);
		
	}
	
	@After("@Login")
	public void afterScenarios() {
		
//		Closing the driver after the test
		
		common.driver.quit();
		
	}
	
}
