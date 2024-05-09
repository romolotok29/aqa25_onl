package models;

import lombok.Data;
import lombok.Getter;

@Data
public class Product {
    private String productName;
    @Getter
    private static String productId;

    public Product(String productName, String productId) {
        this.productName = productName;
        this.productId = productId;
    }
}

