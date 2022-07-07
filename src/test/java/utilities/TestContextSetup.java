package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public WebDriver driver;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.driver);
	}
	
}
