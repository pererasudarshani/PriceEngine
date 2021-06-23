package com.example.priceengine.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The model for the product's carton details
 */
public class ProductCarton {
    int noOfUnits;
    BigDecimal cartonPrice;

    public ProductCarton(int noOfUnits, BigDecimal cartonPrice) {
        this.noOfUnits = noOfUnits;
        this.cartonPrice = cartonPrice;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public BigDecimal getCartonPrice() {
        if (cartonPrice != null) {
            cartonPrice = cartonPrice.setScale(2, RoundingMode.HALF_UP);
        }
        return cartonPrice;
    }

    public void setCartonPrice(BigDecimal cartonPrice) {
        this.cartonPrice = cartonPrice;
    }
}
