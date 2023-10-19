package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class CommonStepDefinitions {
    private WebDriver driver;
    private HomePage homePage;

    public CommonStepDefinitions() {
        this.driver = BeforeAfterStepDefinitions.getDriver();
        homePage = new HomePage(this.driver);
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        driver.get("http://jupiter.cloud.planittesting.com");
    }
}
