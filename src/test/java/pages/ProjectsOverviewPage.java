package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsOverviewPage extends BasePage {

    private final static String pagePath = "/index.php?/admin/projects/overview";

    private final By successfulNewProjectMessageLocator = By.cssSelector(".message-success");

    private final By projectListLocator = By.cssSelector(".hoverSensitive");

    public ProjectsOverviewPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return successfulNewProjectMessageLocator;
    }
    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public WebElement getSuccessfulMessageLabel() {
        return  waitsService.waitForVisibility(successfulNewProjectMessageLocator);
    }

    public String getSuccessfulMessageText() {
        return getSuccessfulMessageLabel().getText();
    }

    public ProjectsOverviewPage goToProjectByName(String name){
        return this;
    }

    public boolean isProjectInList(String name){
        return waitsService.waitForAllVisibleElementsLocatedBy(projectListLocator)
                .stream()
                .anyMatch(s -> s.getText().equals(name));
    }
}
