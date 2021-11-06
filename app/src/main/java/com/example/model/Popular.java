package com.example.model;

public class Popular {
    private int productPopular;
    private String productNamePopular;
    private double productPricePopular;

    public Popular(int productPopular, String productNamePopular, double productPricePopular) {
        this.productPopular = productPopular;
        this.productNamePopular = productNamePopular;
        this.productPricePopular = productPricePopular;
    }

    public void setProductPopular(int productPopular) {
        this.productPopular = productPopular;
    }

    public void setProductNamePopular(String productNamePopular) {
        this.productNamePopular = productNamePopular;
    }

    public void setProductPricePopular(double productPricePopular) {
        this.productPricePopular = productPricePopular;
    }

    public int getProductPopular() {
        return productPopular;
    }

    public String getProductNamePopular() {
        return productNamePopular;
    }

    public double getProductPricePopular() {
        return productPricePopular;
    }
}
