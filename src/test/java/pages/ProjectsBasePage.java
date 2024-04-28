package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsBasePage extends BasePage {

    private final static String pagePath = "index.php?/admin/projects/add/1";

    private final By projectNameInputLocator = By.xpath("//input[@id='name']");

    private final By announcementTextInputLocator = By.cssSelector(".form-control-full");

    private final By showAnnouncementCheckboxLocator = By.cssSelector("#show_announcement");

    private final By singleTestSuiteWithAllCasesLocator = By.xpath
            ("//strong[text()='Use a single repository for all cases (recommended)']");

    private final By singleTestSuiteWithBaselineSupportLocator = By.xpath
            ("//strong[text()='Use a single repository with baseline support']");

    private final By multipleTestSuitesLocator = By.xpath
            ("//strong[text()='Use multiple test suites to manage cases']");

    private final By enableTestCaseApprovalsLocator = By.xpath("//*[text()='Enable Test Case Approvals']");

    public ProjectsBasePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, false);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public WebElement getProjectName() {
        return waitsService.waitForVisibility(projectNameInputLocator);
    }

    public WebElement getAnnouncementTextInput() {
        return waitsService.waitForVisibility(announcementTextInputLocator);
    }

    public WebElement getAnnouncementCheckbox() {
        return waitsService.waitForVisibility(showAnnouncementCheckboxLocator);
    }

    public WebElement getSingleTestSuiteWithAllCases() {
        return waitsService.waitForVisibility(singleTestSuiteWithAllCasesLocator);
    }

    public WebElement getSingleTestSuiteWithBaselineSupport() {
        return waitsService.waitForVisibility(singleTestSuiteWithBaselineSupportLocator);
    }

    public WebElement getMultipleTestSuites() {
        return waitsService.waitForVisibility(multipleTestSuitesLocator);
    }

    public WebElement getTestCaseApprovalsCheckbox() {
        return waitsService.waitForVisibility(enableTestCaseApprovalsLocator);
    }
}
