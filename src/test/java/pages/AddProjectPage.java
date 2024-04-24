package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private final static String pagePath = "index.php?/admin/projects/add/1";

    private final By projectNameInputLocator = By.xpath("//input[@id='name']");

    private final By announcementTextInputLocator = By.cssSelector(".form-control-full");

    private final By showAnnouncementCheckboxLocator = By.cssSelector("#show_announcement");

    private final By singleTestSuiteWithBaselineSupportLocator = By.xpath
            ("//strong[text()='Use a single repository with baseline support']");

    private final By enableTestCaseApprovalsLocator = By.xpath("//*[text()='Enable Test Case Approvals']");

    private final By addProjectButtonLocator = By.id("accept");

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return projectNameInputLocator;
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

    public WebElement getTestSuiteType() {
        return waitsService.waitForVisibility(singleTestSuiteWithBaselineSupportLocator);
    }

    public WebElement getTestCaseApprovalsCheckbox() {
        return waitsService.waitForVisibility(enableTestCaseApprovalsLocator);
    }

    public WebElement getAddProjectButton() {
        return waitsService.waitForVisibility(addProjectButtonLocator);
    }

    public AddProjectPage setProjectName(String value) {
        getProjectName().sendKeys(value);
        return this;
    }

    public AddProjectPage setAnnouncementTextInput(String text) {
        getAnnouncementTextInput().sendKeys(text);
        return this;
    }

    public AddProjectPage setAnnouncementCheckbox() {
        getAnnouncementCheckbox().click();
        return this;
    }

    public AddProjectPage setTestSuiteType() {
        getTestSuiteType().click();
        return this;
    }

    public AddProjectPage setTestCaseApprovalsCheckbox() {
        getTestCaseApprovalsCheckbox().click();
        return this;
    }

    public void clickAddProjectButton() {
        getAddProjectButton().click();
    }

    public void addProject(String projectName, String text) {
        this
                .setProjectName(projectName)
                .setAnnouncementTextInput(text)
                .setAnnouncementCheckbox()
                .setTestSuiteType()
                .setTestCaseApprovalsCheckbox()
                .clickAddProjectButton();
    }

    public ProjectsOverviewPage successfulAddProject(String projectName, String text) {
        addProject(projectName, text);
        return new ProjectsOverviewPage(driver, true);
    }
}
