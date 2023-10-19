package steps;// CartPageStepDefinitions.java
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.CartPage;
import pages.ShopPage;

import java.util.List;

public class CartPageStepDefinitions {

    private WebDriver driver;
    private CartPage cartPage;
    private HomePage homePage;

    private ShopPage shopPage;

    public CartPageStepDefinitions() {
        this.driver = BeforeAfterStepDefinitions.getDriver();
        homePage = new HomePage(this.driver);
        cartPage = new CartPage(this.driver);
        shopPage = new ShopPage(this.driver);
    }

    @When("I go to the cart page")
    public void i_go_to_the_cart_page() {
        homePage.goToCartPage();
    }

    @Then("I should verify the subtotal for each product is correct")
    public void i_should_verify_the_subtotals(List<String> expectedSubtotals) {

        List<String> actualSubtotals = cartPage.getProductSubtotals(); // Implement this method to retrieve the actual subtotals from the cart page

        for (int i = 0; i < expectedSubtotals.size(); i++) {
            String expectedSubtotal = expectedSubtotals.get(i);
            String actualSubtotal = actualSubtotals.get(i);

            // Use assertions to compare the expected and actual subtotals
            Assert.assertEquals(actualSubtotal, expectedSubtotal);
        }
    }

    @Then("I should verify the price for each product")
    public void verifyProductPrices(List<String> expectedPrices) {
        List<String> actualPrices = cartPage.getProductPrices();

        // Assert that actual prices match expected prices
        for (int i = 0; i < expectedPrices.size(); i++) {
            Assert.assertEquals(actualPrices.get(i), expectedPrices.get(i),
                    "Product price doesn't match for product " + (i + 1));
        }
    }

    @Then("I should verify that total is sum of subtotals {double}")
    public void verifyTotalIsSumOfSubtotals(double expectedTotal) {
        double actualTotal = cartPage.calculateTotal();

        // Assert that actual total matches expected total
        Assert.assertEquals(actualTotal, expectedTotal, 0.01); // Provide a tolerance, e.g., 0.01 for floating-point comparison
    }
}
