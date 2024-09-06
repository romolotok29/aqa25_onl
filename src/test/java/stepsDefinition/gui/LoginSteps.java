package stepsDefinition.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Product;
import org.testng.Assert;
import pages.LoginPage;
import pages.products.ProductsPage;
import pages.products.SingleProductPage;

public class LoginSteps extends BaseTest {

    private BaseTest baseTest;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private SingleProductPage singleProductPage;

    public LoginSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("init browser")
    public void startBrowser() {

    }

    @And("open login page")
    public void openLoginPage() {
        baseTest.driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
        loginPage.isPageOpened();
    }

    @When("user {string} with password {string} log in")
    public void user_with_password_log_in(String username, String password) {
        loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Then("products page should be displayed")
    public void isProductsPageDisplayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened());
    }

    @And("clicks on product {string} and adds one item to cart")
    public void clicksOnProduct(String productName) {
        productsPage = new ProductsPage(driver);
        Product product = new Product(productName);
        productsPage.moveToSingleProductPage(product);
    }

    @Then("test should fail and take a screenshot")
    public void testShouldFailAndTakeAScreenshot() {
        singleProductPage = new SingleProductPage(driver);
        singleProductPage.addItemToCart();
        Assert.assertEquals(singleProductPage.getAmountOfItemsInCart(), 2);
        System.out.println("Taking a screenshot");
    }

}