package pages;// CartPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[text()='Stuffed Frog']/following-sibling::td[@class='col-2']")
    private WebElement stuffedFrogSubtotal;

    @FindBy(xpath = "//td[text()='Fluffy Bunny']/following-sibling::td[@class='col-2']")
    private WebElement fluffyBunnySubtotal;

    @FindBy(xpath = "//td[text()='Valentine Bear']/following-sibling::td[@class='col-2']")
    private WebElement valentineBearSubtotal;

    @FindBy(id = "cart-total")
    private WebElement cartTotal;

    public String getStuffedFrogSubtotal() {
        return stuffedFrogSubtotal.getText();
    }

    public String getFluffyBunnySubtotal() {
        return fluffyBunnySubtotal.getText();
    }

    public String getValentineBearSubtotal() {
        return valentineBearSubtotal.getText();
    }

    public String getCartTotal() {
        return cartTotal.getText();
    }
}
