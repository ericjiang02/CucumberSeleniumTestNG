package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div:has(h4.product-title:contains($productName))")
    private WebElement productElement;

    @FindBy(css = "div:has(h4.product-title:contains($productName)) a.btn-success")
    private WebElement buyButton;

    public void addToCart(int quantity, String productName){
        WebElement productElement = driver.findElement(By.xpath(String.format("//li[contains(., '%s')]", productName)));

        WebElement buyButton = productElement.findElement(By.cssSelector("a.btn-success"));

        for (int i = 0; i < quantity; i++) {
            // Click the "Buy" button for the selected product
            buyButton.click();
        }
    }
}