package steps;

import baseEntities.BaseSteps;
import models.Product;
import pages.ShoppingCartPage;
import pages.SingleProductPage;

public class NavigationSteps extends BaseSteps {

    public SingleProductPage navigateToSingleProductPage(Product product) {
        allProductsPage.getProductByName(product).click();
        return new SingleProductPage();
    }

    public ShoppingCartPage navigateToShoppingCartPage() {
        singleProductPage.clickShoppingCartButton();
        return new ShoppingCartPage();
    }
}
