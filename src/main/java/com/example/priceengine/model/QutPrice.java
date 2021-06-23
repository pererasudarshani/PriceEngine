package com.example.priceengine.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The model for the quantity prices against quantity type
 */
public class QutPrice {
    String qutType;
    BigDecimal noOfQut;
    BigDecimal price;

    public String getQutType() {
        return qutType;
    }

    public void setQutType(String qutType) {
        this.qutType = qutType;
    }

    public BigDecimal getNoOfQut() {
        return noOfQut;
    }

    public void setNoOfQut(BigDecimal noOfQut) {
        this.noOfQut = noOfQut;
    }

    public BigDecimal getPrice() {
        if (price != null) {
            price = price.setScale(2, RoundingMode.HALF_UP);
        }
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
