package baseEntities;

import configuration.ReadProperties;
import core.BrowserService;
import models.Project;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    protected User user;
    protected Project project;

    @BeforeTest
    public void setupInfo() {
        user = new User();
        user.setEmail(ReadProperties.email());
        user.setPassword(ReadProperties.password());

        project = new Project();
        project.setName("ValueOfObjects");
        project.setAnnouncementText("Testing with patterns");
        project.setAnnouncementCheckbox(true);
        project.setTestSuiteType(2);
        project.setEnableTCApprovals(false);
    }

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
