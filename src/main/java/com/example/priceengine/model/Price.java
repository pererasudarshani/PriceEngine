package com.example.priceengine.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * The model for the total price details
 */
public class Price {
    String prodCode;
    int noOfUnits;
    List<QutPrice> priceDetails;
    BigDecimal totalPrice;

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public List<QutPrice> getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(List<QutPrice> priceDetails) {
        this.priceDetails = priceDetails;
    }

    public BigDecimal getTotalPrice() {
        if (totalPrice != null) {
            totalPrice = totalPrice.setScale(2, RoundingMode.HALF_UP);
        }
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
