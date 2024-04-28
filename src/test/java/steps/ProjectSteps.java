package steps;

import baseEntities.BaseSteps;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.ProjectsOverviewPage;

public class ProjectSteps extends BaseSteps {

    private AddProjectPage addProjectPage;
    private ProjectsOverviewPage projectsOverviewPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);

        addProjectPage = new AddProjectPage(driver);
        projectsOverviewPage = new ProjectsOverviewPage(driver, true);
    }

    public void addProject(Project project) {

        addProjectPage.setProjectName(project.getName());
        addProjectPage.setAnnouncementText(project.getAnnouncementText());
        addProjectPage.setShowAnnouncementCheckbox(project.getAnnouncementCheckbox());
        addProjectPage.setTestSuiteType(project.getTestSuiteType());
        addProjectPage.setEnableTestCaseApprovalsCheckbox(project.getEnableTCApprovals());
        addProjectPage.clickAddProjectButton();
    }

    public ProjectsOverviewPage successfulAddProject(Project project) {
        addProject(project);
        return projectsOverviewPage;
    }
}
