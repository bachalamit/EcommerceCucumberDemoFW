package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			
		features = {"src/main/resources/features"},
		glue = {"stepdefinitions", "AppHooks"},
		monochrome = true,
		plugin = {"pretty",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:test-out-thread/"
				}		
		
		
		)






public class MyTestRunner {

}
