package stepsDefinition;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.products.ProductsPage;

public class StepsDefinition extends BaseTest {

    private BaseTest baseTest;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public StepsDefinition(BaseTest baseTest) {
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

}