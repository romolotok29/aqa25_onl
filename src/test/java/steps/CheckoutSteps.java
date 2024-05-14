package steps;

import baseEntities.BaseSteps;
import models.User;
import pages.checkout.CheckoutCompletedPage;

public class CheckoutSteps extends BaseSteps {

    public CheckoutCompletedPage completeCheckout(User user) {
        shoppingCartPage
                .clickCheckoutButton()
                .fillCheckoutInfo(user)
                .clickFinishButton();

        return new CheckoutCompletedPage();
    }
}
