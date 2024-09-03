package stepsDefinition;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.products.ProductsPage;
import services.BrowserService;

public class StepsDefinition extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("init browser")
    public void startBrowser() {
        driver = new BrowserService().getDriver();
    }

    @And("open login page")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
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

    @Then("an error message should appear")
    public void anErrorMessageShouldAppear() {
        Assert.assertEquals(loginPage.getErrorTextLockedOutUser(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
