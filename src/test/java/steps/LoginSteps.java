package steps;

import baseEntities.BaseSteps;
import configuration.ReadProperties;
import models.User;
import pages.AllProductsPage;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {

    public AllProductsPage successfulLogin(User user) {
        loginPage
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .clickLoginButton();

        return new AllProductsPage();
    }

    public LoginPage incorrectLogin(String username, User user) {
        loginPage
                .setUsername(username)
                .setPassword(user.getPassword())
                .clickLoginButton();

        return this.loginPage;
    }

    public LoginPage loginAsLockedUser(User lockedOutUser) {
        loginPage
                .setUsername(lockedOutUser.getUsername())
                .setPassword(lockedOutUser.getPassword())
                .clickLoginButton();

        return this.loginPage;
    }
}
