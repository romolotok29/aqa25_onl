package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.DropDown;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class MainTests extends BaseTest {

    @Test
    public void createNewProjectFullySetTest() {
        DashboardPage dashboardPage = new DashboardPage(driver, true);

        Assert.assertTrue(
                dashboardPage
                        .clickAddProjectButton()
                        .addFullySetProject(project)
                        .isProjectInList(project));
    }

    @Test
    public void addCompletedMilestoneTest() {
        DashboardPage dashboardPage = new DashboardPage(driver, true);

        Assert.assertTrue(
                dashboardPage
                        .clickOnProjectOverview(project)
                        .clickAddMilestoneToProject()
                        .addMilestone(milestone)
                        .isMilestoneInGrid(milestone));
    }

    @Test
    public void radioButtonTest() {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage
                .clickAddProjectButton()
                .setProjectName("Radio Button")
                .getSuiteTypeRadioButton()
                .selectByIndex(0);
    }

    @Test
    public void checkboxTest() {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage
                .clickAddProjectButton()
                .setProjectName(project.getName())
                .setShowAnnouncementCheckbox(project.getAnnouncementCheckbox())
                .setTestCaseApprovalsCheckbox(true);
    }

    @Test
    public void selectDropdownByIndexTest() {
        int expectedIndex = 9;
        driver.get(ReadProperties.url() + "index.php?/cases/add/10");
        DropDown dropDown = new DropDown(driver, By.id("type_id_chzn"));
        dropDown.selectByIndex(expectedIndex);

        Assert.assertEquals(dropDown.getCurrentIndex(), expectedIndex);
    }
}
