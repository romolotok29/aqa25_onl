package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class NavigationSteps extends BaseSteps {

    private LoginPage loginPage;

    private ProductsPage productsPage;
    private ShoppingCartPage shoppingCartPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.clickLoginButton();
    }

    public void moveToShoppingCart() {
        productsPage = new ProductsPage(driver);
        productsPage.getCartButton().click();
    }

    public void moveToCheckout() {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.getCheckoutButton().click();

    }
}
