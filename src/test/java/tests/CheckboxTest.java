package tests;

import baseEntities.BaseTest;
import elements.Checkbox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class CheckboxTest extends BaseTest {

    @Test(testName = "Checkbox test")
    public void checkboxTest() {

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddProjectButton();

        Checkbox announcementCheckbox = new Checkbox(driver, By.cssSelector("#show_announcement"));
        announcementCheckbox.setCheckboxStatus(true);

        Checkbox testCaseApprovalsCheckbox = new Checkbox(driver,
                By.xpath("//*[text()='Enable Test Case Approvals']"));

        testCaseApprovalsCheckbox.enableCheckbox();
        testCaseApprovalsCheckbox.disableCheckbox();

    }
}
