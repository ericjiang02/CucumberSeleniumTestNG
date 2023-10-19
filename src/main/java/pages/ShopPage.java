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
        // You may need to locate the specific product element based on its name
        //WebElement productElement = driver.findElement(By.cssSelector(String.format("div:has(h4.product-title:contains('%s'))", productName)));
        //WebElement productElement = driver.findElement(By.xpath(String.format("//div[h4[@class='product-title' and contains(text(), '%s')]]", productName)));
//        WebElement productElement = driver.findElement(By.xpath(String.format("//li[contains(.//h4[@class='product-title' and text()='%s'])]", productName)));
        WebElement productElement = driver.findElement(By.xpath(String.format("//li[contains(., '%s')]", productName)));


        WebElement buyButton = productElement.findElement(By.cssSelector("a.btn-success"));

        for (int i = 0; i < quantity; i++) {
            // Click the "Buy" button for the selected product
            buyButton.click();

            // You may need to wait for a confirmation message or other feedback
            // to ensure that the product was added to the cart successfully.
        }
    }
}