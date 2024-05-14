package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import models.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final String pagePath = "/";

    private final By usernameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.cssSelector("#password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorTextLabelLocator = By.tagName("h3");
    private final By errorLockedOutLocator = By.tagName("h3");

    public void openPage() {
        open(pagePath);
    }

    public SelenideElement getUsernameInput() {
        return $(usernameInputLocator).shouldBe(visible);
    }

    public SelenideElement getPasswordInput() {
        return $(passwordInputLocator);
    }

    public SelenideElement getLoginButton() {
        return $(loginButtonLocator);
    }

    public SelenideElement getErrorTextLabel() {
        return $(errorTextLabelLocator);
    }

    public SelenideElement getErrorTextLockedOutUser() { return $(errorLockedOutLocator);
    }

    public LoginPage setUsername(String username) {
        getUsernameInput().sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String username) {
        getPasswordInput().sendKeys(username);
        return this;
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}
