package pages.milestones;

import baseEntities.BasePage;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MilestoneOverviewPage extends BasePage {

    private final By milestonesHeaderLocator = By.className("content-header-title");
    @FindBy(xpath = "//a[contains (@href, 'milestones/view')]")
    public List<WebElement> milestonesList;

    public MilestoneOverviewPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return milestonesHeaderLocator;
    }

    @Override
    protected String getPagePath() {
        return "";
    }


    public boolean isMilestoneInGrid(Milestone milestone) {
        for (WebElement element:
                milestonesList) {
            if (element.getText().trim().equals(milestone.getName())) {
                return true;
            }
        }
        return false;
    }
}
