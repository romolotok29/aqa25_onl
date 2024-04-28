package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends ProjectsBasePage {

    private final static String pagePath = "index.php?/admin/projects/add/1";
    private final By addProjectButtonLocator = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        this(driver, false);
    }

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return addProjectButtonLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public WebElement getAddProjectButton() {
        return waitsService.waitForVisibility(addProjectButtonLocator);
    }

    public AddProjectPage setProjectName(String value) {
        getProjectName().sendKeys(value);
        return this;
    }

    public AddProjectPage setAnnouncementText(String value) {
        getAnnouncementTextInput().sendKeys(value);
        return this;
    }

    public AddProjectPage setShowAnnouncementCheckbox(boolean value) {
        if(value) {
            getAnnouncementCheckbox().click();
        }
        return this;
    }

    public AddProjectPage setTestSuiteType(int value) {
        if (value == 1) {
            getSingleTestSuiteWithAllCases().click();
        } else if (value ==2) {
            getSingleTestSuiteWithBaselineSupport().click();
        } else if (value == 3) {
            getMultipleTestSuites().click();
        }
        return this;
    }

    public AddProjectPage setEnableTestCaseApprovalsCheckbox(boolean value) {
        if (value) {
            getTestCaseApprovalsCheckbox().click();
        }
        return this;
    }

    public void clickAddProjectButton() {
        getAddProjectButton().click();
    }
}
