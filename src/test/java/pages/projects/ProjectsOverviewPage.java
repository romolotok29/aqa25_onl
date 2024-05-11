package pages.projects;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.milestones.AddMilestonePage;

public class ProjectsOverviewPage extends BasePage {
    private final By contentHeaderTitleLocator = By.xpath("//*[@class='content-header-title page_title']");
    private final By addMilestoneButtonLocator = By.id("navigation-overview-addmilestones");

    public ProjectsOverviewPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return contentHeaderTitleLocator;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    public Button getAddMilestoneButton() {
        return new Button(driver, addMilestoneButtonLocator);
    }

    public AddMilestonePage clickAddMilestoneToProject() {
        getAddMilestoneButton().click();
        return new AddMilestonePage(driver, false);
    }
}
