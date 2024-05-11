package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.DropDown;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void selectDropdownByTextTest() {
        String expectedText = "Functional";
        driver.get(ReadProperties.url() + "index.php?/cases/add/10");
        DropDown dropDown = new DropDown(driver, By.id("type_id_chzn"));
        dropDown.getByText(expectedText);

        Assert.assertEquals(dropDown.getCurrentTextValue(), expectedText);

    }
}
