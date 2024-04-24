package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class incorrectLoginTest extends BaseTest {

    @Test
    public void incorrectLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(
                loginPage
                        .incorrectLogin("something", ReadProperties.password())
                        .getErrorText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
}
