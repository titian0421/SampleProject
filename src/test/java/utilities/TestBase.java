package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public String browser;
	public Properties prop;
	
	public TestBase() throws IOException {
//		Getting the information from the properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/global.properties");
		prop = new Properties();
		prop.load(fis);
		
//		Validating the selected browser for the test
		browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			chromeDriverConnection();
		}
		if(browser.equalsIgnoreCase("mozilla") | browser.equalsIgnoreCase("firefox")) {
			mozillaDriverConnection();
		}
		if(browser.equalsIgnoreCase("edge")) {
			edgeDriverConnection();
		}
	}
	
//	Getting the Username directly from the properties file
	public String getUsername() {
		return prop.getProperty("username");
	}
	
//	Getting the Password directly from the properties file
	public String getPassword() {
		return prop.getProperty("password");
	}
	
//	Getting the login url directly from the properties file
	public String getLoginLink() {
		return prop.getProperty("loginurl");
	}
	
//	Creating connection with ChromeDriver
	public WebDriver chromeDriverConnection() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		} else {
			return driver;
		}
	}
	
//	Creating connection with FirefoxDriver
	public WebDriver mozillaDriverConnection() {
		if(driver == null) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/firefox/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		}else {
			return driver;
		}
	}
	
//	Creating connection with EdgeDriver
	public WebDriver edgeDriverConnection() {
		if(driver == null) {
			System.setProperty("webdriver.edge.driver", "./src/test/resources/edge/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		}else {
			return driver;
		}
	}
	
//	Wrapping the method get of WebDriver
	public void get(String url) {
		driver.get(url);
	}
	
//	Wrapping the method getCurrentUrl of WebDriver
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
//	Wrapping the method quit of WebDriver
	public void quit() {
		driver.quit();
	}
	
//	Wrapping the method close of WebDriver
	public void close() {
		driver.close();
	}
	
//	Wrapping the method isDisplayed of WebElement
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
//	Wrapping the method findElement of WebElement
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
//	Wrapping the method sendKeys of WebElement
	public void sendKeys(WebElement webElement, String string) {
		webElement.sendKeys(string);
	}
	
//	Wrapping the method click of WebElement
	public void click(WebElement webElement) {
		webElement.click();
	}
	
//	Wrapping the method getText of WebElement
	public String getText(WebElement webElement) {
		return webElement.getText();
	}
	
}
