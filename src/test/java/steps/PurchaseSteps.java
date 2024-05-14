package steps;

import baseEntities.BaseSteps;
import pages.SingleProductPage;

public class PurchaseSteps extends BaseSteps {

    public SingleProductPage addToCartFromSingleProductPage() {
        singleProductPage.clickAddToCartButton();
        return this.singleProductPage;
    }
}
