package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import utilities.TestBase;

public class LogoutPage extends TestBase {

//	Defining By variables
	By username = By.xpath("//input[contains(@id, 'Username')]");
	By password = By.xpath("//input[contains(@id, 'Password')]");
	By loginBtn = By.xpath("//input[contains(@id, 'btn')]");
	By welcomeMenu = By.xpath("//a[contains(@id, 'welcome') or contains(text(), 'Welcome')]");
	By logoutOption = By.xpath("//a[contains(@href, 'logout') or contains(text(), 'Logout')]");
	
//	Getting the information from the properties file
	
	public LogoutPage() throws IOException {
		super();
	}

	public void loginWithCredentials() {
		get(getLoginLink());
		sendKeys(findElement(username), getUsername());
		sendKeys(findElement(password), getPassword());
		click(findElement(loginBtn));
	}
	
	public void showWelcomeOptions() {
		click(findElement(welcomeMenu));
	}
	
	public void logout() {
		click(findElement(logoutOption));
	}
	
}
