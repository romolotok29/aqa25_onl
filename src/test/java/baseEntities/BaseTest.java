package baseEntities;

import configuration.ReadProperties;
import models.Product;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import services.BrowserService;

public class BaseTest {

    protected WebDriver driver;
    protected User simpleUser;
    protected Product product;

    @BeforeClass
    public void setUpData() {
        simpleUser = new User.Builder()
                .withUsername(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .withFirstName("Michael")
                .withLastName("Williams")
                .withPostalCode("102030")
                .build();

        product = new Product("Sauce Labs Bolt T-Shirt", "1");
    }

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
