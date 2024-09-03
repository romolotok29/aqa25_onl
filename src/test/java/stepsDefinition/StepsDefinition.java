package stepsDefinition;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class StepsDefinition extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);

    @Given("login page is opened")
    public void login_page_is_opened() {
        loginPage.isPageOpened();
    }

    @When("user {string} with password {string} log in")
    public void user_with_password_log_in(String username, String password) {
        loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Then("error with {string} should appear")
    public void error_with_should_appear(String message) {
        message = loginPage.getErrorTextLockedOutUser();
        Assert.assertEquals(message,
                "Epic sadface: Sorry, this user has been locked out.");
    }
}
