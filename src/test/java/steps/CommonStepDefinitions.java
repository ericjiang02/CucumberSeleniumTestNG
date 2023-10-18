package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactPage;
import pages.HomePage;
import runners.TestRunner;

public class CommonStepDefinitions {
    private WebDriver driver;
    private HomePage homePage;

    public CommonStepDefinitions() {
        this.driver = BeforeAfterStepDefinitions.getDriver();
        homePage = new HomePage(this.driver);
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
//        driver = new ChromeDriver();
//        homePage = new HomePage(driver);
        // Ensure that the driver is not already initialized in TestRunner
//        if (driver == null) {
//            driver = new ChromeDriver();
//            TestRunner.setDriver(driver); // Set the driver in TestRunner for sharing
//        }

        driver.get("http://jupiter.cloud.planittesting.com");
    }
}
