package steps;

import baseEntities.BaseSteps;
import models.UserBuilder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.products.ProductsPage;

public class NavigationSteps extends BaseSteps {

    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public ProductsPage loginIsSuccessful(UserBuilder user) {
        return new LoginPage(driver).successfulLogin(user);
    }
}
