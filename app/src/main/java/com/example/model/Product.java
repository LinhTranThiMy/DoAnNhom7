package com.example.model;

public class Product {
    private int ProductThumb;
    private String ProductName;
    private double ProductPrice;

    public Product(int productThumb, String productName, double productPrice) {
        ProductThumb = productThumb;
        ProductName = productName;
        ProductPrice = productPrice;
    }

    public int getProductThumb() {
        return ProductThumb;
    }

    public void setProductThumb(int productThumb) {
        ProductThumb = productThumb;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }
}
