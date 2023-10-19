package runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.cucumber.java.Before;
import io.cucumber.java.After;

@CucumberOptions(features = "src/test/resources/features", // Adjust the path as needed
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@run" // Specify the tag you want to run
) // Package containing step definitions
public class TestRunner extends AbstractTestNGCucumberTests {

}

