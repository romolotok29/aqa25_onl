package pages;

import baseEntities.BaseSteps;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.Product;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class AllProductsPage {

    private static final String pagePath = "/";
    private final By productsTitleLocator = By.cssSelector(".title");
    private final By productListLocator = By.cssSelector(".inventory_item_name");

    public void openPage() {
        open(pagePath);
    }

    public ElementsCollection getProductList() {
        return $$(productListLocator);
    }

    public SelenideElement getProductByName(String productName) {
        for (SelenideElement selenideElement : getProductList()) {
            if (selenideElement.getText().contains(productName)) {
                return selenideElement;
            }
        }
        return null;
    }

    public SelenideElement getProductByName(Product product) {
        for (SelenideElement selenideElement :
                getProductList()) {
            if (selenideElement.getText().contains(product.getProductName())) {
                return selenideElement;
            }
        }
        return null;
    }
}
