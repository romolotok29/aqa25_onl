package baseEntities;

import com.google.common.collect.ImmutableMap;
import configuration.ReadProperties;
import models.Product;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

//@Listeners(InvokedListener.class)
public class BaseTest {

    protected static WebDriver driver;
    public static String service;
    protected User simpleUser;
    protected Product product;
    protected LoginPage loginPage;

    @BeforeSuite
    void setAllureEnvironment() {
        allureEnvironmentWriter(ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "123.0")
                        .put("Stand", "Production")
                        .build());
    }

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

    /*
    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowserService().getDriver();
        this.setDriverToContext(iTestContext, driver);
        driver.get(ReadProperties.getUrl());
    }
     */

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("WebDriver", driver);
    }

    public static WebDriver getDriverFromContext(ITestContext iTestContext) {
        return (WebDriver) iTestContext.getAttribute("WebDriver");
    }

}