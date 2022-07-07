package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LoginPage loginPage;
	public DirectoryPage directoryPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLoginPage() throws IOException {
		loginPage = new LoginPage();
		return loginPage;
	}
	
	public DirectoryPage getDirectoryPage() {
		directoryPage = new DirectoryPage(driver);
		return directoryPage;
	}
	
}
