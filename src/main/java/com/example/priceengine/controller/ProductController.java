package com.example.priceengine.controller;

import com.example.priceengine.model.Product;
import com.example.priceengine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The controller for the product
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * The get method for all the products
     *
     * @return The response entity with list of products
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity(productService.getProducts(), HttpStatus.OK);
    }

    /**
     * The get method for a product
     *
     * @param prodCode The product code
     * @return The response entity with the product
     */
    @GetMapping("/{prodCode}")
    public ResponseEntity<Product> getProduct(@PathVariable("prodCode") String prodCode) {
        Product product = productService.getProduct(prodCode);
        return product != null ? new ResponseEntity(product, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
