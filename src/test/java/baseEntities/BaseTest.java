package baseEntities;

import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();

        driver.get(ReadProperties.url());
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }
}
