package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AdditionalTests extends BaseTest {
    @Test
    public void incorrectLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterUsername("wrongUsername")
                .enterPassword(simpleUser.getPassword())
                .clickLoginButton();

        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginAsLockedUserTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterUsername("locked_out_user")
                .enterPassword(simpleUser.getPassword())
                .clickLoginButton();

        Assert.assertEquals(loginPage.getErrorTextLockedOutUser(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void productPresenceTest() {
        Assert.assertTrue(
                new LoginPage(driver)
                        .successfulLogin(simpleUser)
                        .getProductByName(product.getProductName())
                        .isDisplayed()
        );
    }

    @Test
    public void navigateToSingleProductPageByIndex(){
        new LoginPage(driver)
                .successfulLogin(simpleUser)
                .moveToProductByIndex(9);

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory-item.html?id="));
    }

    @Test
    public void addSingleProductToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(
                loginPage
                        .successfulLogin(simpleUser)
                        .moveToSingleProductPage(product)
                        .addItemToCart()
                        .getAmountOfItemsInCart(), 1
        );
    }
}

