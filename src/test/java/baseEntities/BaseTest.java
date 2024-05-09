package baseEntities;

import configuration.ReadProperties;
import models.Product;
import models.UserBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import services.BrowserService;

public class BaseTest {

    protected Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected UserBuilder simpleUser;
    protected Product product;

    @BeforeClass
    public void setUpData() {
        simpleUser = UserBuilder
                .builder()
                .username(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .firstName("John")
                .lastName("Doe")
                .postalCode("102030")
                .build();

        product = new Product("Sauce Labs Bolt T-Shirt", "1");
    }

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

}
