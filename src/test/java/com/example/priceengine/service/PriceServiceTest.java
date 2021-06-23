package com.example.priceengine.service;

import com.example.priceengine.model.Price;
import com.example.priceengine.model.Product;
import com.example.priceengine.model.ProductCarton;
import com.example.priceengine.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import static com.example.priceengine.util.Constant.UNIT_QUT_TYPE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

/**
 * The test class for PriceService
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PriceServiceTest {

    List<Product> products ;
    Product prod0001;
    Product prod0002;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private PriceService priceService;

    /**
     * Setup data for test
     */
    @BeforeEach
    void setup() {
        // The carton details
        ProductCarton carton1 = new ProductCarton(5, new BigDecimal("825.00", new MathContext(2)));
        ProductCarton carton2 = new ProductCarton(20, new BigDecimal("175.00", new MathContext(2)));

        // The product details
        prod0001 = new Product(1, "prod0001", "Horseshoe", "Horseshoe", carton1);
        prod0002 = new Product(2, "prod0002", "Penguin-ears", "Penguin-ears", carton2);
        products = new ArrayList<Product>();
        products.add(prod0001);
        products.add(prod0002);

    }

    @Test
    void basicContractsAreEmpty() throws Exception {
        // Given
        when(productRepository.getProduct("prod0001")).thenReturn(prod0001);

        // When
        Price price = priceService.getPrice("prod0001",UNIT_QUT_TYPE,2);

        // Then
        assertThat(price.getTotalPrice().doubleValue(), is(431.60));
    }

}
