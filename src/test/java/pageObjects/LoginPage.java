package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import utilities.TestBase;

public class LoginPage extends TestBase {

//	Defining By variables
	By username = By.xpath("//input[contains(@id, 'Username')]");
	By password = By.xpath("//input[contains(@id, 'Password')]");
	By loginBtn = By.xpath("//input[contains(@id, 'btn')]");
	By message = By.xpath("//div[contains(@id, 'LoginButton')]/span");
		
	public LoginPage() throws IOException {
		super();
	}
	
	public void loadLoginPage() {
		get(getLoginLink());
	}
	
	public void insertUsername(String user) {
		sendKeys(findElement(username), user);
	}
	
	public void insertPassword(String pass) {
		sendKeys(findElement(password), pass);
	}
	
	public void pressLoginBtn() {
		click(findElement(loginBtn));
	}
	
	public boolean validateAdvice() {
		return isDisplayed(message);
	}
	
}
