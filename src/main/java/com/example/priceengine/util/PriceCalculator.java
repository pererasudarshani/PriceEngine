package com.example.priceengine.util;

import com.example.priceengine.model.ProductCarton;

import java.math.BigDecimal;

/**
 * The interface for price calculation strategy
 */
public interface PriceCalculator {
    public BigDecimal calculate(int qut, ProductCarton carton);
}

