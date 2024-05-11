package tests;

import baseEntities.BaseTest;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class RadioButtonTest extends BaseTest {

    @Test(testName = "Select test suite by index")
    public void radioButtonTest() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddProjectButton();

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByIndex(1);
        radioButton.selectByIndex(2);
        radioButton.selectByIndex(0);
    }

    @Test(testName = "Select test suite by index (Specially falling test)")
    public void radioButtonFailTest() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddProjectButton();

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByIndex(0);
        radioButton.selectByIndex(3);
    }

    @Test(testName = "Select test suite by value")
    public void radioButtonTest2() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddProjectButton();

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByValue1("1");
        radioButton.selectByValue2("3");

    }

    @Test(testName = "Select test suite by text ")
    public void radioButtonTest3() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddProjectButton();

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByText1("Use a single repository with baseline support");
        radioButton.selectByText2("Use a single repository for all cases (recommended)");

    }
}
