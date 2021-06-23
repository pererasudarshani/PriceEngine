package com.example.priceengine.util;

import com.example.priceengine.model.ProductCarton;

import java.math.BigDecimal;
import java.math.MathContext;

import static com.example.priceengine.util.Constant.SINGLE_UNIT_COMPENSATION;

/**
 * The class for unit price calculation strategy
 */
public class UnitPriceCalculator implements PriceCalculator {
    @Override
    public BigDecimal calculate(int qut, ProductCarton carton) {
        return carton.getCartonPrice().multiply(SINGLE_UNIT_COMPENSATION)
                .divide(new BigDecimal(carton.getNoOfUnits(), new MathContext(2)))
                .multiply(new BigDecimal(qut));
    }
}
