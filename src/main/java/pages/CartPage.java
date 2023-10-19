package pages;// CartPage.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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


    @FindBy(css = "strong.total.ng-binding")
    private WebElement totalElement;

    public List<String> getProductSubtotals() {
        List<String> subtotals = new ArrayList<>();

        // Locate the subtotal elements within the table's tbody
        List<WebElement> subtotalElements = driver.findElements(By.xpath("//tr[contains(@class, 'cart-item')]/td[4]"));

        // Extract and add the text values of the subtotal elements to the 'subtotals' list
        for (WebElement subtotalElement : subtotalElements) {
            subtotals.add(subtotalElement.getText());
        }

        return subtotals;
    }

    public List<String> getProductPrices() {
        List<String> prices = new ArrayList<>();

        // Locate the price elements within the table's tbody
        List<WebElement> priceElements = driver.findElements(By.xpath("//tr[contains(@class, 'cart-item')]/td[2]"));

        // Extract and add the text values of the price elements to the 'prices' list
        for (WebElement priceElement : priceElements) {
            prices.add(priceElement.getText());
        }

        return prices;
    }

    public double calculateTotal(){
        // Extract and return the double value of the total
        String totalText = totalElement.getText();
        return Double.parseDouble(totalText.replace("Total: ", ""));
    }
}
