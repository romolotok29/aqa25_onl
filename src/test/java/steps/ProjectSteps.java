package steps;

import baseEntities.BaseSteps;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;
import pages.projects.AdminProjectsOverviewPage;

public class ProjectSteps extends BaseSteps {

    private AddProjectPage addProjectPage;
    private AdminProjectsOverviewPage adminProjectsOverviewPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);

        addProjectPage = new AddProjectPage(driver);
        adminProjectsOverviewPage = new AdminProjectsOverviewPage(driver, true);
    }

    public void addProject(Project project) {

        addProjectPage.setProjectName(project.getName());
        addProjectPage.setAnnouncementText(project.getAnnouncementText());
        addProjectPage.setShowAnnouncementCheckbox(project.getAnnouncementCheckbox());
        addProjectPage.setProjectType(1);
        addProjectPage.setTestCaseApprovalsCheckbox(project.getEnableTCApprovals());
        addProjectPage.clickAddProjectButton();
    }

    public AdminProjectsOverviewPage successfulAddProject(Project project) {
        addProject(project);
        return adminProjectsOverviewPage;
    }
}
