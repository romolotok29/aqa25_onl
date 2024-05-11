package elements;

import core.WaitsService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {

    private List<UIElement> uiElementList;
    private List<String> valuesList;
    private List<String> textsList;

    //Поиск элемента производится по name атрибуту

    public RadioButton(WebDriver driver, By locator) {
        uiElementList = new ArrayList<>();
        valuesList = new ArrayList<>();
        textsList = new ArrayList<>();

        for (WebElement webElement : new WaitsService(driver).waitForAllElementsLocatedBy(locator)) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(element);
            valuesList.add(webElement.getAttribute("value"));
            textsList.add(element.findElement(By.xpath("parent::*/strong")).getText().trim());
        }
    }

    public void selectByIndex(int index) {
        if (index < uiElementList.size()) {
            uiElementList.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Индекс больше размера коллекции");
        }
    }

    public void selectByValue1(String value) {
        try {
            for (UIElement uiElement : uiElementList) {
                if (uiElement.getAttribute("value").equals(value)) {
                    uiElement.click();
                    return;
                }
            }

        } catch (Exception ex) {

        }
    }

    public void selectByValue2(String value) {
        uiElementList.get(valuesList.indexOf(value)).click();
    }

    public void selectByText1(String text) {
        try {
            for (UIElement uiElement : uiElementList) {
                UIElement parent = uiElement.findElement(By.xpath("parent::*"));
                if (parent.getTagName().equals("div")) {
                    if (parent.getText().trim().equals(text)) {
                        uiElement.click();
                        return;
                    }

                } else if (parent.getTagName().equals("label")) {
                    if (parent.findElement(By.tagName("strong")).getText().trim().equals(text)) {
                        uiElement.click();
                        return;
                    }
                }
            }

        } catch (Exception ex) {

        }
    }

    public void selectByText2(String text) {
        uiElementList.get(textsList.indexOf(text)).click();
    }
}
