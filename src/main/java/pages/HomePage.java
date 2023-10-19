package pages;// HomePage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "nav-shop")
    private WebElement shopMenu;

    @FindBy(id = "nav-contact")
    private WebElement contactMenu;

    @FindBy(id = "nav-cart")
    private WebElement cartMenu;

    public void goToShopPage() {
        shopMenu.click();
    }

    public void goToContactPage() {
        contactMenu.click();
    }

    public void goToCartPage() {
        cartMenu.click();
    }
}