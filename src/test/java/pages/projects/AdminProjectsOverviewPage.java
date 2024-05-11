package pages.projects;

import baseEntities.BasePage;
import elements.UIElement;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminProjectsOverviewPage extends BasePage {

    private final static String pagePath = "/index.php?/admin/projects/overview";
    private final By projectGridLocator = By.className("grid");
    @FindBy(css = ".hoverSensitive")
    public List<WebElement> projectsList;
    private final By successfulNewProjectMessageLocator = By.cssSelector(".message-success");

    public AdminProjectsOverviewPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return projectGridLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public UIElement getSuccessfulMessageLabel() {
        return new UIElement(driver, successfulNewProjectMessageLocator);
    }

    public String getSuccessfulMessageText() {
        return getSuccessfulMessageLabel().getText();
    }

    public boolean isProjectInList(Project project) {
        for (WebElement element :
                projectsList) {
            if (element.getText().trim().equals(project.getName())) {
                return true;
            }
        }
        return false;
    }

}
