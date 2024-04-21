package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import pages.checkout.CheckoutCompletePage;
import pages.checkout.CheckoutInformationPage;
import pages.checkout.CheckoutOverviewPage;
import steps.CheckoutSteps;
import steps.NavigationSteps;
import steps.ProductSteps;

public class EndToEndTest extends BaseTest {
    @Test(testName = "E2E login, add to cart and checkout")
    public void e2eTest() {

        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.login(ReadProperties.username(), ReadProperties.password());

        Assert.assertTrue(new ProductsPage(driver).isPageOpened());

        ProductSteps productSteps = new ProductSteps(driver);
        productSteps.addToCart(3);
        navigationSteps.moveToShoppingCart();

        Assert.assertTrue(new ShoppingCartPage(driver).isPageOpened());

        navigationSteps.moveToCheckout();
        Assert.assertTrue(new CheckoutInformationPage(driver).isPageOpened());

        CheckoutSteps checkoutSteps = new CheckoutSteps(driver);
        checkoutSteps.fillCheckoutInfo("Michael", "Williams", "53821");
        Assert.assertTrue(new CheckoutOverviewPage(driver).isPageOpened());
        checkoutSteps.finishCheckout();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.isPageOpened());

        System.out.println(checkoutCompletePage.getPageUrl());
        Assert.assertEquals(checkoutCompletePage.getPageUrl(),
                "https://www.saucedemo.com/checkout-complete.html");

        Assert.assertEquals(checkoutCompletePage.getCompleteTitleText(), "Checkout: Complete!");
        Assert.assertEquals(checkoutCompletePage.getCompleteHeaderText(),
                "Thank you for your order!");

        Assert.assertEquals(checkoutCompletePage.getCompleteMessageText(),
                "Your order has been dispatched, and will arrive just as fast " +
                        "as the pony can get there!");

        Assert.assertTrue(checkoutCompletePage.hasBackButton());

    }
}
