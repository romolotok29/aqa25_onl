package baseEntities;

import configuration.ReadProperties;
import core.BrowserService;
import models.Milestone;
import models.Project;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import steps.NavigationSteps;

public class BaseTest {

    protected WebDriver driver;
    protected User user;
    protected Project project;
    protected Milestone milestone;

    @BeforeTest
    public void setupInfo() {
        user = new User();
        user.setEmail(ReadProperties.email());
        user.setPassword(ReadProperties.password());

        project = new Project();
        project.setName("Wrappers");
        project.setAnnouncementText("Testing with wrappers");
        project.setAnnouncementCheckbox(true);
        project.setTestSuiteType(2);
        project.setEnableTCApprovals(false);

        milestone = new Milestone();
        milestone.setName("Milestone");
        milestone.setReference("Some reference");
        milestone.setDescription("Description of milestone");
        milestone.setCompleted(true);
    }

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.url());
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.successfulLogin(user);

    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }
}
