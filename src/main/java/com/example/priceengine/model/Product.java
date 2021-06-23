package com.example.priceengine.model;

/**
 * The model for the product
 */
public class Product {
    int id;
    String prodCode;
    String prodName;
    String prodDisc;
    ProductCarton productCarton;

    public Product(int id, String prodCode, String prodName, String prodDisc, ProductCarton productCarton) {
        this.id = id;
        this.prodCode = prodCode;
        this.prodName = prodName;
        this.prodDisc = prodDisc;
        this.productCarton = productCarton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDisc() {
        return prodDisc;
    }

    public void setProdDisc(String prodDisc) {
        this.prodDisc = prodDisc;
    }

    public ProductCarton getProductCarton() {
        return productCarton;
    }

    public void setProductCarton(ProductCarton productCarton) {
        this.productCarton = productCarton;
    }
}
