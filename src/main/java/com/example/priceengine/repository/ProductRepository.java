package com.example.priceengine.repository;

import com.example.priceengine.model.Product;
import com.example.priceengine.model.ProductCarton;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * The repository for the product
 */
@Component
public class ProductRepository {

    // The carton details
    ProductCarton carton1 = new ProductCarton(5, new BigDecimal("825.00", new MathContext(2)));
    ProductCarton carton2 = new ProductCarton(20, new BigDecimal("175.00", new MathContext(2)));

    // The product details
    Product prod0001 = new Product(1, "prod0001", "Horseshoe", "Horseshoe", carton1);
    Product prod0002 = new Product(2, "prod0002", "Penguin-ears", "Penguin-ears", carton2);

    /**
     * The get products details
     *
     * @return The list of products
     */
    public List<Product> getProducts() {

        List<Product> products = new ArrayList<Product>();
        products.add(prod0001);
        products.add(prod0002);
        return products;

    }

    /**
     * The get a product details
     *
     * @param prodCode The product code
     * @return The product
     */
    public Product getProduct(String prodCode) {
        if (prodCode.equals(prod0001.getProdCode())) {
            return prod0001;
        } else if (prodCode.equals(prod0002.getProdCode())) {
            return prod0002;
        }
        return null;
    }

    /**
     * Verification for product availability
     *
     * @param prodCode The product code
     * @return The availability
     */
    public boolean isProductAvailable(String prodCode) {
        if (prodCode.equals(prod0001.getProdCode()) || prodCode.equals(prod0002.getProdCode())) {
            return true;
        }
        return false;
    }
}


