package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DropDown {

    private List<UIElement> uiElementListDropDown;
    private List<String> elementTextList;
    private UIElement uiElement;

    public DropDown(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
        uiElementListDropDown = uiElement.findUIElements(By.xpath("*/descendant::li"));
        elementTextList = new ArrayList<String>();
    }

    private void expandDropDown() {
        uiElement.click();
    }

    public void selectByIndex(int index) {
        expandDropDown();
        uiElementListDropDown.get(index).click();
    }

    public void getByText(String text) {
        uiElementListDropDown.get(setElementTextList().indexOf(text)).click();
    }

    private List<String> setElementTextList() {
        expandDropDown();
        for (UIElement uiElement: uiElementListDropDown) {
            elementTextList.add(uiElement.getText());
        }
        return elementTextList;
    }

    public String getCurrentTextValue() {
        return uiElement.findElement(By.xpath("*/descendant::span")).getText();
    }

    public int getCurrentIndex() {
        return setElementTextList().indexOf(getCurrentTextValue());
    }
}
