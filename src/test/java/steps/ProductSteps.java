package steps;

import baseEntities.BaseSteps;
import models.Product;
import org.openqa.selenium.WebDriver;
import pages.products.ProductsPage;
import pages.products.SingleProductPage;

public class ProductSteps extends BaseSteps {

    public ProductSteps(WebDriver driver) {
        super(driver);
    }

    public SingleProductPage addToCartFromSingleProductPage(Product product) {
        return new ProductsPage(driver)
                .moveToSingleProductPage(product)
                .addItemToCart();
    }
}
