package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import utilities.TestBase;

public class DirectoryPage extends TestBase {

//	Defining By variables
	By username = By.xpath("//input[contains(@id, 'Username')]");
	By password = By.xpath("//input[contains(@id, 'Password')]");
	By loginBtn = By.xpath("//input[contains(@id, 'btn')]");
	By directoryModule = By.xpath("//a[contains(@id, 'directory')]");
	By nameField = By.xpath("//input[@id='searchDirectory_emp_name_empName']");
	By searchBtn = By.xpath("//input[@id='searchBtn']");
	By resetBtn = By.xpath("//input[@id='resetBtn']");
	By results = By.xpath("//table[@id='resultTable']//b");
	By message = By.xpath("//div[@class='box searchForm']//div[@class='inner']");
	
	public DirectoryPage() throws IOException {
		super();
	}
	
	public void loginWithCredentials() {
		get(getLoginLink());
		sendKeys(findElement(username), getUsername());
		sendKeys(findElement(password), getPassword());
		click(findElement(loginBtn));
	}

	public void goToDirectory() {
		click(findElement(directoryModule));
	}
	
	public void inputName(String name) {
		sendKeys(findElement(nameField), name);
	}
	
	public void search() {
		click(findElement(searchBtn));
	}
	
	public void clearResults() {
		click(findElement(resetBtn));
	}
	
	public String validateResults() {
		return getText(findElement(results));
	}
	
	public String getMessage() {
		return getText(findElement(message));
	}
	
	public String getNameField() {
		return getText(findElement(nameField));
	}
	
}
