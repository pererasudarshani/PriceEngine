package com.example.priceengine.controller;

import com.example.priceengine.model.Price;
import com.example.priceengine.service.PriceService;
import com.example.priceengine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.priceengine.util.Constant.CARTON_QUT_TYPE;
import static com.example.priceengine.util.Constant.UNIT_QUT_TYPE;

/**
 * The controller for the price
 */
@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    PriceService priceService;

    @Autowired
    ProductService productService;

    /**
     * The prices get method
     *
     * @return The response entity with list of prices
     */
    @GetMapping
    public ResponseEntity<List<Price>> getPrices() {
        return new ResponseEntity(priceService.getPrices(), HttpStatus.OK);
    }

    /**
     * The price get method for a product
     *
     * @param prodCode The product code
     * @param qutType  The product quantity type
     * @param qut      The product quantity
     * @return The response entity with price of the product
     */
    @GetMapping("/{prodCode}")
    public ResponseEntity<Price> getPrices(@PathVariable("prodCode") String prodCode,
                                           @RequestParam("qutType") String qutType, @RequestParam("qut") int qut) {
        if (!productService.isProductAvailable(prodCode)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else if (qutType.equalsIgnoreCase(UNIT_QUT_TYPE) || qutType.equalsIgnoreCase(CARTON_QUT_TYPE)) {
            return new ResponseEntity(priceService.getPrice(prodCode, qutType, qut), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(priceService.getPrice(prodCode, qutType, qut), HttpStatus.OK);
        }
    }
}
