package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.Input;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final static String pagePath = "";

    //Блок описания локаторов

    private final By emailInputLocator = By.xpath("//input[@id='name']");
    private final By passwordInputLocator = By.xpath("//input[@id = 'password']");
    private final By loginButtonLocator = By.xpath("//button[@id = 'button_primary']");
    private final By errorTextLabelLocator = By.xpath("//div[@class='error-text']");

    //Блок инициализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Блок атомарных методов
    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }
    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public Input getEmailInput() {
        return new Input(driver, emailInputLocator);
    }

    public Input getPasswordInput() {
        return new Input(driver, passwordInputLocator);
    }

    public LoginPage setEmail(String value) {
        getEmailInput().sendKeys(value);
        return this;
    }

    public LoginPage setPassword(String value) {
        getPasswordInput().sendKeys(value);
        return this;
    }

    public Button getLoginButton() {
        return new Button(driver, loginButtonLocator);
    }

    public UIElement getErrorTextLabel() {
        return new UIElement(driver, errorTextLabelLocator);
    }

    public String getErrorText() {
        return getErrorTextLabel().getText();
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}
