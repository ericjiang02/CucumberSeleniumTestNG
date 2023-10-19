package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactPage extends BasePage {

    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 5;
    public ContactPage(WebDriver driver) {
        super(driver);
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    @FindBy(id = "forename")
    private WebElement forenameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(xpath = "//a[@class='btn-contact btn btn-primary']")
    private WebElement submitButton;

    @FindBy(id = "forename-err")
    private WebElement forenameIsRequiredErrorMessage;

    @FindBy(id = "email-err")
    private WebElement emailIsRequiredErrorMessage;

    @FindBy(id = "message-err")
    private WebElement messageIsRequiredErrorMessage;

    @FindBy(className = "alert-success")
    private WebElement successMessage;

    public void populateMandatoryFields(String forename, String email, String message) {
        forenameInput.sendKeys(forename);
        emailInput.sendKeys(email);
        messageInput.sendKeys(message);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isForenameErrorMessageDisplayed() {
        waitDriver.until(ExpectedConditions.visibilityOf(forenameIsRequiredErrorMessage));
        return forenameIsRequiredErrorMessage.isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed() {
        waitDriver.until(ExpectedConditions.visibilityOf(emailIsRequiredErrorMessage));
        return emailIsRequiredErrorMessage.isDisplayed();
    }

    public boolean isMessageErrorMessageDisplayed() {
        waitDriver.until(ExpectedConditions.visibilityOf(messageIsRequiredErrorMessage));
        return messageIsRequiredErrorMessage.isDisplayed();
    }

    public String getSuccessMessageText() {
        waitDriver.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }
}