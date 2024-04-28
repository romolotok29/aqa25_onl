package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private final static String pagePath = "index.php?/dashboard";

    private final By dashboardPageLocator = By.cssSelector(".page_title");

    private final By addProjectButtonLocator = By.id("sidebar-projects-add");


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

    public WebElement getAddProjectButton(){
        return waitsService.waitForVisibility(addProjectButtonLocator);
    }

    public AddProjectPage addProject() {
        getAddProjectButton().click();
        return new AddProjectPage(driver);
    }
}
