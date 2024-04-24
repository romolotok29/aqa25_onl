package baseEntities;

import configuration.ReadProperties;
import core.BrowserService;
import core.WaitsService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    private WaitsService waitsService;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        waitsService = new WaitsService(driver);


        driver.get(ReadProperties.url());
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }
}
