package stepsDefinition.gui;

import baseEntities.BaseTest;
import io.cucumber.java.en.And;
import pages.ShoppingCartPage;
import pages.products.SingleProductPage;

public class ShoppingCartSteps extends BaseTest {

    private BaseTest baseTest;
    private SingleProductPage singleProductPage;
    private ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @And("moves to shopping cart and proceeds to checkout")
    public void movesToShoppingCartAndProceedsToCheckout() {
        singleProductPage = new SingleProductPage(driver);
        singleProductPage
                .moveToShoppingCart()
                .proceedToCheckout();
    }


}
