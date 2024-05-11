package pages.projects;

import baseEntities.BasePage;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import elements.RadioButton;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BasePage {

    private final static String pagePath = "index.php?/admin/projects/add/";
    private final By projectNameInputLocator = By.xpath("//input[@id='name']");
    private final By announcementTextInputLocator = By.cssSelector(".form-control-full");
    private final By showAnnouncementCheckboxLocator = By.cssSelector("#show_announcement");
    private final By testSuiteTypeRadioButtonLocator = By.name("suite_mode");
    private final By testCaseApprovalsCheckboxLocator = By.xpath("//*[text()='Enable Test Case Approvals']");
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

    public Input getProjectNameInput() {
        return new Input(driver, projectNameInputLocator);
    }

    public Input getAnnouncementTextInput() {
        return new Input(driver, announcementTextInputLocator);
    }

    public Checkbox getAnnouncementCheckbox() {
        return new Checkbox(driver, showAnnouncementCheckboxLocator);
    }

    public RadioButton getSuiteTypeRadioButton() { return new RadioButton(driver, testSuiteTypeRadioButtonLocator); }

    public Checkbox getTestCaseApprovalsCheckbox() {
        return new Checkbox(driver, testCaseApprovalsCheckboxLocator);
    }

    public Button getAddProjectButton() {
        return new Button(driver, addProjectButtonLocator);
    }

    public void clickAddProjectButton() {
        getAddProjectButton().click();
    }

    public AddProjectPage setProjectName(String projectName) {
        getProjectNameInput().sendKeys(projectName);
        return this;
    }

    public AddProjectPage setAnnouncementText(String announcementText) {
        getAnnouncementTextInput().sendKeys(announcementText);
        return this;
    }

    public AddProjectPage setShowAnnouncementCheckbox(boolean isShown) {
        if(isShown) {
            getAnnouncementCheckbox().enableCheckbox();
        } else {
            getAnnouncementCheckbox().disableCheckbox();
        }
        return this;
    }

    public AddProjectPage setProjectType(int index) {
        getSuiteTypeRadioButton().selectByIndex(index);
        return this;
    }

    public AddProjectPage setTestCaseApprovalsCheckbox(boolean isEnabled) {
        if (isEnabled) {
            getTestCaseApprovalsCheckbox().enableCheckbox();
        } else {
            getTestCaseApprovalsCheckbox().disableCheckbox();
        }
        return this;
    }

    public AdminProjectsOverviewPage addFullySetProject(Project project) {
        this
                .setProjectName(project.getName())
                .setAnnouncementText(project.getAnnouncementText())
                .setProjectType(project.getTestSuiteType())
                .setTestCaseApprovalsCheckbox(project.getEnableTCApprovals())
                .clickAddProjectButton();

        return new AdminProjectsOverviewPage(driver, true);
    }
}
