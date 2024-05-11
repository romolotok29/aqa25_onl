package pages.milestones;

import baseEntities.BasePage;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddMilestonePage extends BasePage {
    private final By nameInputLocator = By.xpath("//input[@id='name']");
    private final By referenceInputLocator = By.xpath("//input[@name='reference']");
    private final By milestoneIsCompletedCheckboxLocator = By.id("is_completed");
    private final By addMilestoneButtonLocator = By.xpath("//button[@id='accept']");

    public AddMilestonePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected By getPageIdentifier() {
        return nameInputLocator;
    }

    @Override
    protected String getPagePath() {
        return null;
    }

    public Input getNameInput() {
        return new Input(driver, nameInputLocator);
    }

    public Input getReferenceInput() {
        return new Input(driver, referenceInputLocator);
    }

    public Checkbox getMilestoneIsCompletedCheckbox() {
        return new Checkbox(driver, milestoneIsCompletedCheckboxLocator);
    }

    public Button getAddMilestoneButton() {
        return new Button(driver, addMilestoneButtonLocator);
    }

    public void clickAddMilestoneButton() {
        getAddMilestoneButton().click();
    }

    public AddMilestonePage enterMilestoneName(String nameInput) {
        getNameInput().sendKeys(nameInput);

        return this;
    }

    public AddMilestonePage enterMilestoneReference(String referenceInput) {
        getReferenceInput().sendKeys(referenceInput);

        return this;
    }

    public AddMilestonePage setMilestoneIsCompletedCheckbox(boolean isCompleted) {
        if (!isCompleted) {
            getMilestoneIsCompletedCheckbox().enableCheckbox();
        }
        return this;
    }

    public MilestoneOverviewPage addMilestone(Milestone milestone) {
        enterMilestoneName(milestone.getName())
                .enterMilestoneReference(milestone.getReference())
                .setMilestoneIsCompletedCheckbox(milestone.isCompleted())
                .clickAddMilestoneButton();

        return new MilestoneOverviewPage(driver, false);
    }
}
