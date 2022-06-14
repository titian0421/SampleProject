package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/features/"},
		glue = "stepDefinitions",
		tags = "@Logout"
		)

public class testRunner extends AbstractTestNGCucumberTests {

}
