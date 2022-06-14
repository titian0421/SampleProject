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

public class LogoutDefinitions {
	
	public String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login"; //The login page
	public CommonInstructions common; //Using the dependency injection option with PicoContainer
	public String username = "Admin";
	public String password = "admin123";
	

	public LogoutDefinitions(CommonInstructions common) {
		
		this.common = common;
		
	}
	
	@Before("@Logout")
	public void beforeScenarios() {
		
//		Setting up the driver
		
		WebDriverManager.chromedriver().setup();
		
		common.driver = new ChromeDriver();
		
		common.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("I am in the Dashboard page and logged into my account")
	public void i_am_in_the_dashboard_page_and_logged_into_my_account() {
	    
//		Getting and loading the login page
		
		common.driver.get(loginUrl);
		
//		Inserting username for log in process
		
		WebElement usernameElement = common.driver.findElement(By.xpath("//input[contains(@id, 'Username')]")); //Getting the Username field element
	    
		usernameElement.sendKeys(username);
		
//		Inserting password for log in process
		
		WebElement passwordElement = common.driver.findElement(By.xpath("//input[contains(@id, 'Password')]")); //Getting the Password field element
		
		passwordElement.sendKeys(password);
		
//		Clicking on login button
		
		WebElement buttonElement = common.driver.findElement(By.xpath("//input[contains(@id, 'btn')]")); //Getting the login button element
		
		buttonElement.click();
		
	}
	@When("I go to the welcome options")
	public void i_go_to_the_welcome_options() {
	    
//		Clicking to show the welcome options
		
		WebElement optionsElement = common.driver.findElement(By.xpath("//a[contains(@id, 'welcome') or contains(text(), 'Welcome')]")); //Getting the welcome menu element
	    
		optionsElement.click();
		
	}

	@When("I click the Logout option")
	public void i_click_the_logout_option() {
	    
//		Clicking to show the welcome options
		
		WebElement logoutElement = common.driver.findElement(By.xpath("//a[contains(@href, 'logout') or contains(text(), 'Logout')]")); //Getting the logout element
	    
		logoutElement.click();
		
	}

	@Then("I am in the Login page")
	public void i_am_in_the_login_page() {
	    
		Assert.assertEquals(common.driver.getCurrentUrl(), loginUrl);
		
	}
	
	@After("@ForgotPass")
	public void afterScenarios() {
		
//		Closing the driver after the test
		
		common.driver.quit();
		
	}
	
}
