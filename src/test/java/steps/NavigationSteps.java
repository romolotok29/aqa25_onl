package steps;

import baseEntities.BaseSteps;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class NavigationSteps extends BaseSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    private void login(String email, String password) {
        loginPage
                .setEmail(email)
                .setPassword(password)
                .clickLoginButton();
    }

    public DashboardPage successfulLogin(String email, String password) {
        login(email, password);
        return dashboardPage;
    }

    public DashboardPage successfulLogin(User user) {
        return successfulLogin(user.getEmail(), user.getPassword());
    }
}
