package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.checkout.CheckoutCompletePage;

public class EndToEndTest extends BaseTest {
    @Test
    public void e2eTest() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage
                        .successfulLogin(simpleUser)
                        .moveToSingleProductPage(product)
                        .addItemToCart()
                        .moveToShoppingCart()
                        .moveToCheckout()
                        .fillCheckoutInfo(simpleUser)
                        .finishCheckout()
                        .isPageOpened()
        );

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        Assert.assertEquals(
                checkoutCompletePage
                        .getCompleteTitleText(), "Checkout: Complete!"
        );

        Assert.assertEquals(
                checkoutCompletePage
                        .getCompleteMessageText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        );

        Assert.assertTrue(
                checkoutCompletePage
                        .hasBackHomeButton()
        );

    }
}

