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

    public String getStuffedFrogSubtotal() {
        return stuffedFrogSubtotal.getText();
    }

    public String getFluffyBunnySubtotal() {
        return fluffyBunnySubtotal.getText();
    }

    public String getValentineBearSubtotal() {
        return valentineBearSubtotal.getText();
    }


//    public List<WebElement> getProductRows() {
//        return driver.findElements(By.cssSelector("table.cart-items tbody tr"));
//    }

//    public void verifySubtotals(List<String> expectedSubtotals) {
//        List<WebElement> productRows = getProductRows();
//
//        // Ensure that the number of rows matches the number of expected subtotals
//        Assert.assertEquals(productRows.size(), expectedSubtotals.size());
//
//        for (int i = 0; i < productRows.size(); i++) {
//            WebElement productRow = productRows.get(i);
//
//            // Extract the actual subtotal from the UI
//            WebElement subtotalElement = productRow.findElement(By.cssSelector("td:nth-child(4)"));
//            String actualSubtotal = subtotalElement.getText();
//
//            // Retrieve the expected subtotal from the list
//            String expectedSubtotal = expectedSubtotals.get(i);
//
//            // Validate that the actual subtotal matches the expected subtotal
//            Assert.assertEquals(actualSubtotal, expectedSubtotal, "Subtotal for product #" + (i + 1) + " is incorrect.");
//        }
//    }

    public List<String> getProductSubtotals() {
        List<String> subtotals = new ArrayList<>();

        // Locate the subtotal elements within the table's tbody
        //List<WebElement> subtotalElements = driver.findElements(By.xpath("//table[@class='table table-striped cart-items']//tbody//td[@class='ng-binding' and contains(text(), '$')]"));
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
//        List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table table-striped cart-items']//tbody//td[@class='ng-binding' and contains(text(), '$')]"));
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
