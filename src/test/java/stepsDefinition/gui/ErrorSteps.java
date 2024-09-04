package stepsDefinition.gui;

import baseEntities.BaseTest;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

public class ErrorSteps extends BaseTest {

    private BaseTest baseTest;

    public ErrorSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Then("an error message for locked out user should appear")
    public void anErrorMessageShouldAppear() {
        LoginPage loginPage = new LoginPage(baseTest.driver);

        Assert.assertEquals(loginPage.getErrorTextLockedOutUser(),
                "Epic sadface: Sorry, this user has been locked out.");
    }
}
