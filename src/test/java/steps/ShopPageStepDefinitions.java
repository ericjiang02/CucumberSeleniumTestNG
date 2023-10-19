package steps;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ShopPage;

import java.util.List;
import java.util.Map;

public class ShopPageStepDefinitions {

    private WebDriver driver;

    private HomePage homePage;

    private ShopPage shopPage;

    public ShopPageStepDefinitions() {
        this.driver = BeforeAfterStepDefinitions.getDriver();
        homePage = new HomePage(this.driver);
        shopPage = new ShopPage(this.driver);
    }

    @When("I go to the shop page")
    public void i_go_to_the_shop_page() {
        homePage.goToShopPage();
    }

//    @When("add 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear")
//    public void add_to_cart(){
//
//    }

//    @When("add (\\d+) (.+) to the cart")
//    public void add_to_cart(int quantity, String productName) {
//        shopPage.addToCart(quantity, productName);
//    }

    @When("I add the following products to the cart:")
    public void i_add_the_following_products_to_the_cart(List<Map<String, String>> productData) {
        for (Map<String, String> data : productData) {
            int quantity = Integer.parseInt(data.get("Quantity"));
            String productName = data.get("Product");
            String expectedPrice = data.get("ExpectedPrice");

            shopPage.addToCart(quantity, productName);
            // Your code to add the product to the cart with the specified quantity and verify the expected price
            // Implement this part based on your application's functionality and page objects
        }
    }
}