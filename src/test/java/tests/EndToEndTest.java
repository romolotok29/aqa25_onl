package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

@Epic("Epic")
@Feature("General feature")
public class EndToEndTest extends BaseTest {

    @Description("E2E login, add to cart and complete checkout!")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка главных функций сайта https://www.saucedemo.com")
    public void e2eTest() {

        loginSteps.successfulLogin(user);

        navigationSteps.navigateToSingleProductPage(product);

        purchaseSteps
                .addToCartFromSingleProductPage()
                .getShoppingCartButton()
                .shouldBe(clickable);

        navigationSteps.navigateToShoppingCartPage();

        checkoutSteps
                .completeCheckout(user)
                .getCompleteTitle()
                .shouldHave(exactText("Checkout: Complete!"))
                .shouldBe(visible);

    }
}
