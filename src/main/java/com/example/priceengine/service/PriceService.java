package com.example.priceengine.service;

import com.example.priceengine.model.Price;
import com.example.priceengine.model.Product;
import com.example.priceengine.model.QutPrice;
import com.example.priceengine.repository.ProductRepository;
import com.example.priceengine.util.CartonPriceCalculator;
import com.example.priceengine.util.PriceCalculator;
import com.example.priceengine.util.UnitPriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.priceengine.util.Constant.CARTON_QUT_TYPE;
import static com.example.priceengine.util.Constant.UNIT_QUT_TYPE;

/**
 * The service for the pricing
 */
@Service
public class PriceService {

    @Autowired
    ProductRepository productRepository;

    /**
     * The prices get method
     *
     * @return The list of prices
     */
    public List<Price> getPrices() {
        List<Product> products = productRepository.getProducts();
        List<Price> prices = new LinkedList();
        for (int i = 0; i < products.size(); i++) {
            for (int unit = 1; unit <= 50; unit++) {
                prices.add(getPrice(products.get(i).getProdCode(), UNIT_QUT_TYPE, unit));
            }
        }
        return prices;
    }

    /**
     * The price get method for a product
     *
     * @param prodCode The product code
     * @param qutType  The product quantity type
     * @param qut      The product quantity
     * @return The price of the product
     */
    public Price getPrice(String prodCode, String qutType, int qut) {

        Product product = productRepository.getProduct(prodCode);
        PriceCalculator priceCalculator = null;
        int cartonCount = 0;
        int unitCount = 0;
        Price price = new Price();
        ArrayList<QutPrice> qutPriceList = new ArrayList<>();

        if (qutType.equalsIgnoreCase(CARTON_QUT_TYPE)) {
            cartonCount = qut;
        } else if (qutType.equalsIgnoreCase(UNIT_QUT_TYPE)) {
            cartonCount = qut / product.getProductCarton().getNoOfUnits();
            unitCount = qut % product.getProductCarton().getNoOfUnits();
            ;
        }

        if (cartonCount > 0) {
            priceCalculator = new CartonPriceCalculator();
            QutPrice cartonPrice = new QutPrice();
            cartonPrice.setPrice(priceCalculator.calculate(cartonCount, product.getProductCarton()));
            cartonPrice.setNoOfQut(new BigDecimal(cartonCount));
            cartonPrice.setQutType(CARTON_QUT_TYPE);
            qutPriceList.add(cartonPrice);
            price.setTotalPrice(cartonPrice.getPrice());
        }

        if (unitCount > 0) {
            priceCalculator = new UnitPriceCalculator();
            QutPrice unitPrice = new QutPrice();
            unitPrice.setPrice(priceCalculator.calculate(unitCount, product.getProductCarton()));
            unitPrice.setNoOfQut(new BigDecimal(unitCount));
            unitPrice.setQutType(UNIT_QUT_TYPE);
            qutPriceList.add(unitPrice);
            if (price.getTotalPrice() == null) {
                price.setTotalPrice(unitPrice.getPrice());
            } else {
                price.setTotalPrice(price.getTotalPrice().add(unitPrice.getPrice()));
            }
        }
        price.setProdCode(prodCode);
        price.setNoOfUnits(qut);
        price.setPriceDetails(qutPriceList);
        return price;
    }
}
