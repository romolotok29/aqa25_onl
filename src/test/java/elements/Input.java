package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    private UIElement uiElement;

    public Input(WebDriver driver, By locator) {
        this.uiElement = new UIElement(driver, locator);
    }

    public void sendKeys(CharSequence... keysToSend) {
        uiElement.sendKeys(keysToSend);
    }

    public void clearAndSendKeys(CharSequence... keysToSend) {
        uiElement.clear();
        sendKeys(keysToSend);
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }
}
