package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.ContactPage;
import pages.HomePage;
import runners.TestRunner;

public class ContactPageStepDefinitions {
    private WebDriver driver;
    private ContactPage contactPage;
    //private HomePage homePage = new HomePage();
    private HomePage homePage;

    public ContactPageStepDefinitions() {
        this.driver = BeforeAfterStepDefinitions.getDriver();

        homePage = new HomePage(this.driver);
        contactPage = new ContactPage(this.driver);
    }

    @When("I go to the contact page")
    public void i_go_to_the_contact_page() {
//        HomePage homePage = new HomePage(driver);
        homePage.goToContactPage();
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        contactPage.clickSubmitButton();
    }

    @Then("I should see error messages")
    public void i_should_see_error_messages() {
        assert(contactPage.isForenameErrorMessageDisplayed());
        assert(contactPage.isEmailErrorMessageDisplayed());
        assert(contactPage.isMessageErrorMessageDisplayed());
    }

    @When("I populate mandatory fields with name {string}, email {string} and message {string}")
    public void i_populate_mandatory_fields_with_name_and_email(String name, String email, String message) {
        contactPage.populateMandatoryFields(name, email, message);
    }

    @Then("I should not see error messages")
    public void i_should_not_see_error_messages() {
        assert(!contactPage.isForenameErrorMessageDisplayed());
        assert(!contactPage.isEmailErrorMessageDisplayed());
        assert(!contactPage.isMessageErrorMessageDisplayed());
    }

    @Then("I should see a successful submission message")
    public void i_should_see_a_successful_submission_message() {
        Assert.assertEquals(contactPage.getSuccessMessageText(), "Thanks John, we appreciate your feedback.");
    }
}
