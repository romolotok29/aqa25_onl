package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.UIElement;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.projects.AddProjectPage;
import pages.projects.ProjectsOverviewPage;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends BasePage {

    private final static String pagePath = "index.php?/dashboard";
    private final By dashboardPageLocator = By.cssSelector(".page_title");
    private final By addProjectButtonLocator = By.id("sidebar-projects-add");
    @FindBy(xpath = "//div[contains (@class, 'summary-title text-ppp')]/a[contains (@href, 'projects/overview')]")
    public List<WebElement> projectsOnDashboard;


    public DashboardPage(WebDriver driver) {
        this(driver, false);
    }

    public DashboardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return dashboardPageLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public Button getAddProjectButton() {
        return new Button(driver, addProjectButtonLocator);
    }


    public AddProjectPage clickAddProjectButton() {
        getAddProjectButton().click();

        return new AddProjectPage(driver, true);
    }

    public ProjectsOverviewPage clickOnProjectOverview(Project project) {
        for (WebElement element :
                projectsOnDashboard) {
            if (element.getText().trim().equals(project.getName())) {
                element.click();
                return new ProjectsOverviewPage(driver, false);
            }
        }
        return null;
    }
}
