package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import utilities.TestBase;

public class ForgotPassPage extends TestBase {

	//	Defining By variables
	By resetPass = By.xpath("//a[contains(@href, 'requestPasswordResetCode')]");
	By userField = By.xpath("//input[contains(@id, 'userName')]");
	By resetBtn = By.xpath("//input[contains(@id, 'Search')]");
	By message = By.xpath("//div[contains(@class, 'warning')]");
	
	public ForgotPassPage() throws IOException {
		super();
	}
	
	public void loadLoginPage() {
		get(getLoginLink());
	}
	
	public void clickForgotPass() {
		click(findElement(resetPass));
	}
	
	public void inputUsername(String username) {
		sendKeys(findElement(userField), username);;
	}
	
	public void clickOnResetBtn() {
		click(findElement(resetBtn));
	}
	
	public String getMessageConfirmation() {
		return getText(findElement(message));
	}

}
