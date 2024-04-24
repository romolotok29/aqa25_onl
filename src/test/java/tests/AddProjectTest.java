package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectsOverviewPage;

public class AddProjectTest extends BaseTest {

    @Test(dataProvider = "projectName", dataProviderClass = StaticProvider.class)
    public void successfulAddProjectTest(String projectName) {

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage
                        .successfulLogin(ReadProperties.email(), ReadProperties.password())
                        .isPageOpened()
        );

        DashboardPage dashboardPage = new DashboardPage(driver, true);

        Assert.assertEquals(
                dashboardPage
                        .addProject()
                        .successfulAddProject("Testing with ChainOfInvocations", "Announcement text")
                        .getSuccessfulMessageText(), "Successfully added the new project."
        );

        ProjectsOverviewPage projectsOverviewPage = new ProjectsOverviewPage(driver, true);

        Assert.assertTrue(
                projectsOverviewPage
                        .goToProjectByName(projectName)
                        .isProjectInList(projectName)
        );
    }
}
