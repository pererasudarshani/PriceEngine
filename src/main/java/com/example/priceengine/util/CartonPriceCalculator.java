package com.example.priceengine.util;

import com.example.priceengine.model.ProductCarton;

import java.math.BigDecimal;

import static com.example.priceengine.util.Constant.DISCOUNT;

/**
 * The class for carton price calculation strategy
 */
public class CartonPriceCalculator implements PriceCalculator {
    @Override
    public BigDecimal calculate(int qut, ProductCarton carton) {
        if (qut >= 3) {
            return carton.getCartonPrice().subtract(carton.getCartonPrice().multiply(DISCOUNT)).multiply(new BigDecimal(qut));
        } else {
            return carton.getCartonPrice().multiply(new BigDecimal(qut));
        }
    }

}
