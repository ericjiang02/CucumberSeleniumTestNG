package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
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
        return forenameIsRequiredErrorMessage.isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed() {
        return emailIsRequiredErrorMessage.isDisplayed();
    }

    public boolean isMessageErrorMessageDisplayed() {
        return messageIsRequiredErrorMessage.isDisplayed();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }
}