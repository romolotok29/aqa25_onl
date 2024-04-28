package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import data.StaticProvider;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectsOverviewPage;
import steps.NavigationSteps;
import steps.ProjectSteps;

public class AddProjectTest extends BaseTest {

    @Test(dataProvider = "project", dataProviderClass = StaticProvider.class)
    public void successfulAddProjectTest(String projectName) {

        NavigationSteps navigationSteps = new NavigationSteps(driver);

        User user = new User();
        user.setEmail(ReadProperties.email());
        user.setPassword(ReadProperties.password());

        Project expectedProject = new Project();
        expectedProject.setName("Testing with ValueOfObjects");
        expectedProject.setAnnouncementText("Some announcement text");
        expectedProject.setAnnouncementCheckbox(true);
        expectedProject.setTestSuiteType(1);
        expectedProject.setEnableTCApprovals(false);

        navigationSteps
                .successfulLogin(user)
                .addProject();

        ProjectSteps projectSteps = new ProjectSteps(driver);

        Assert.assertEquals(
                projectSteps
                        .successfulAddProject(expectedProject)
                        .getSuccessfulMessageText(), "Successfully added the new project."
        );

        ProjectsOverviewPage projectsOverviewPage = new ProjectsOverviewPage(driver, true);

        Assert.assertTrue(
                projectsOverviewPage
                        .isProjectInList(projectName)
        );
    }
}
