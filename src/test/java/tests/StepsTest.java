package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.CheckoutSteps;
import steps.NavigationSteps;
import steps.ProductSteps;

public class StepsTest extends BaseTest {

    @Test
    public void stepsFullFlowTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);

        navigationSteps
                .loginIsSuccessful(simpleUser);

        ProductSteps productSteps = new ProductSteps(driver);

        productSteps
                .addToCartFromSingleProductPage(product);

        CheckoutSteps checkoutSteps = new CheckoutSteps(driver);

        Assert.assertTrue(
                checkoutSteps.completeCheckout(simpleUser)
                        .isPageOpened());

    }
}
