package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {

    private UIElement uiElement;

    public Button (WebDriver driver, By locator) {
        this.uiElement = new UIElement(driver, locator);
    }

    public void click() {
        uiElement.click();
    }

    public void submit() {
        uiElement.submit();
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }
}
