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

public class forgotpassDefinitions {
	
//	public WebDriver driver; //Global driver variable
	public String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login"; //The login page
	public String wrongMessage = "Please contact HR admin in order to reset the password"; //The wrong message we receive when insert nonexistent users in recovery password page
	CommonInstructions common;
	
	public forgotpassDefinitions(CommonInstructions common){
		
		this.common = common;
		
	}
	
	@Before("@ForgotPass")
	public void beforeScenarios() {
		
//		Setting up the driver
		
		WebDriverManager.chromedriver().setup();
		
		common.driver = new ChromeDriver();
		
		common.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@When("I click on Forgot your password? link")
	public void i_click_on_forgot_your_password_link() {
	    
//		Clicking on forgot your password link
		
		WebElement forgotLink = common.driver.findElement(By.xpath("//a[contains(@href, 'requestPasswordResetCode')]"));
	
		forgotLink.click();
		
	}

	@When("I put {string} in the OrangeHRM Username field")
	public void i_put_in_the_orange_hrm_username_field(String username) {
	    
//		Inserting the Username that we need recover it's password 
		
		WebElement userField = common.driver.findElement(By.xpath("//input[contains(@id, 'userName')]"));
		
		userField.sendKeys(username);
		
	}

	@When("I click on Reset Password button")
	public void i_click_on_reset_password_button() {
	    
//		Clicking on reset button
		
		WebElement resetButton = common.driver.findElement(By.xpath("//input[contains(@id, 'Search')]"));
		
		resetButton.click();
		
	}

	@Then("I receive the right message confirmation")
	public void i_receive_the_right_message_confirmation() {
	    
//		Getting the notification message in order to compare and validate the process
		
		String message = common.driver.findElement(By.xpath("//div[contains(@class, 'warning')]")).getText();
		
		Assert.assertNotEquals(message, wrongMessage);
		
	}

	@Then("I receive the wrong message confirmation")
	public void i_receive_the_wrong_message_confirmation() {
	    
//		Getting the notification message in order to compare and validate the process
		
		String message = common.driver.findElement(By.xpath("//div[contains(@class, 'warning')]")).getText();
		
		Assert.assertEquals(message.contains(wrongMessage), true);
		
	}
	
	@After("@ForgotPass")
	public void afterScenarios() {
		
//		Closing the driver after the test
		
		common.driver.quit();
		
	}

}
