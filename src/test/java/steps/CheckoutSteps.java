package steps;

import baseEntities.BaseSteps;
import models.UserBuilder;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPage;
import pages.checkout.CheckoutCompletePage;

public class CheckoutSteps extends BaseSteps {

    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage completeCheckout(UserBuilder user) {
        return new ShoppingCartPage(driver)
                .moveToCheckout()
                .fillCheckoutInfo(user)
                .finishCheckout();
    }
}
