package baseEntities;

import pages.AllProductsPage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import pages.SingleProductPage;
import pages.checkout.CheckoutCompletedPage;
import pages.checkout.CheckoutInfoPage;
import pages.checkout.CheckoutOverviewPage;

public class BaseSteps {

    protected LoginPage loginPage;
    protected AllProductsPage allProductsPage;
    protected SingleProductPage singleProductPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutInfoPage checkoutInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletedPage checkoutCompletedPage;

    public BaseSteps() {
        loginPage = new LoginPage();
        allProductsPage = new AllProductsPage();
        singleProductPage = new SingleProductPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutInfoPage = new CheckoutInfoPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletedPage = new CheckoutCompletedPage();
    }
}
