package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import models.Product;
import models.User;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import steps.CheckoutSteps;
import steps.LoginSteps;
import steps.NavigationSteps;
import steps.PurchaseSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ SoftAsserts.class})
public class BaseTest {

    protected User user;
    protected User lockedUser;
    protected Product product;
    protected LoginSteps loginSteps;
    protected NavigationSteps navigationSteps;
    protected PurchaseSteps purchaseSteps;
    protected CheckoutSteps checkoutSteps;

    @BeforeSuite
    public void setupSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = ReadProperties.url();
        Configuration.browser = ReadProperties.browser();
        Configuration.headless = ReadProperties.headless();
        ChromeOptions options = new ChromeOptions();
        Configuration.browserCapabilities = options;
        options.addArguments("--incognito");
        Configuration.pageLoadTimeout = ReadProperties.pageLoadTimeout() * 1000;
        Configuration.timeout = ReadProperties.timeout() * 1000;
        Configuration.assertionMode = AssertionMode.SOFT;
        //Configuration.browser = Browsers.CHROME;
        //Configuration.browserSize = "1680x1050";
        //Configuration.fastSetValue = true;
    }

    @BeforeClass
    public void setupData() {
        user = new User.Builder()
                .withUsername(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .withFirstName("Josh")
                .withLastName("Double")
                .withPostalCode("102030")
                .build();

        lockedUser = new User.Builder()
                .withUsername("locked_out_user")
                .withPassword(ReadProperties.password())
                .build();

        product = new Product("Sauce Labs Backpack", "4");

        loginSteps = new LoginSteps();
        navigationSteps = new NavigationSteps();
        purchaseSteps = new PurchaseSteps();
        checkoutSteps = new CheckoutSteps();
    }

    @BeforeMethod
    public void setupBrowser() {
        open("/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
