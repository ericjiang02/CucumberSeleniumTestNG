package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", // Adjust the path as needed
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@run" // Specify the tag you want to run
) // Package containing step definitions
public class TestRunner extends AbstractTestNGCucumberTests {

}

