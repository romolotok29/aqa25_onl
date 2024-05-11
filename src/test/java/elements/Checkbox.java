package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {

    private UIElement uiElement;
    private WebDriver driver;

    public Checkbox(WebDriver driver, By locator) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, locator);
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }

    public void setCheckboxStatus(boolean status) {
        if (isSelected() != status) {
            uiElement.click();
        }
    }

    public void enableCheckbox() {
        setCheckboxStatus(true);
    }

    public void disableCheckbox() {
        setCheckboxStatus(false);
    }
}
