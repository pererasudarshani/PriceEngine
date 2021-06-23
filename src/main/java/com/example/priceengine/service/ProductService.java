package com.example.priceengine.service;

import com.example.priceengine.model.Product;
import com.example.priceengine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The service for the product
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * Get all the products
     *
     * @return The list of products
     */
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    /**
     * The get a product details
     *
     * @param prodCode The product code
     * @return The product
     */
    public Product getProduct(String prodCode) {
        return productRepository.getProduct(prodCode);
    }

    /**
     * Verification for product availability
     *
     * @param prodCode The product code
     * @return The availability
     */
    public boolean isProductAvailable(String prodCode) {
        return productRepository.isProductAvailable(prodCode);
    }
}
