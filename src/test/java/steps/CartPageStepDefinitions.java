package steps;// CartPageStepDefinitions.java
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.CartPage;

public class CartPageStepDefinitions {

    private WebDriver driver;
    private CartPage cartPage;
    private HomePage homePage;

    public CartPageStepDefinitions() {
        this.driver = BeforeAfterStepDefinitions.getDriver();
        homePage = new HomePage(this.driver);
        cartPage = new CartPage(this.driver);
    }

    @When("I go to the shop page")
    public void i_go_to_the_shop_page() {
        homePage.goToShopPage();
    }

    @When("add 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear")
    public void add_to_cart(){

    }

    @When("I go to the cart page")
    public void i_go_to_the_cart_page() {
        homePage.goToCartPage();
    }

    @Then("Verify the subtotal for each product is correct")
    public void verify_the_subtotal_for_each_product_is_correct() {
        // Implement verification logic for product subtotals
        String stuffedFrogSubtotal = cartPage.getStuffedFrogSubtotal();
        String fluffyBunnySubtotal = cartPage.getFluffyBunnySubtotal();
        String valentineBearSubtotal = cartPage.getValentineBearSubtotal();
        // Perform the necessary assertions here
    }

    @Then("Verify the price for each product")
    public void verify_the_price_for_each_product() {
        // Implement verification logic for product prices
        // Extract prices for Stuffed Frog, Fluffy Bunny, Valentine Bear, and perform assertions
    }

    @Then("Verify that total = sum(sub totals)")
    public void verify_that_total_equals_sum_of_subtotals() {
        String cartTotal = cartPage.getCartTotal();
        // Implement the logic to calculate the sum of subtotals and compare with cartTotal
    }
}
