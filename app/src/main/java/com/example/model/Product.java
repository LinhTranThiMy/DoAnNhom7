package com.example.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int ProductThumb;
    private String ProductName;
    private double ProductPrice;
    private Float ProductRating;
    private String ProductRatingNumber;

    public Product(int productThumb, String productName, double productPrice, Float productRating, String productRatingNumber) {
        ProductThumb = productThumb;
        ProductName = productName;
        ProductPrice = productPrice;
        ProductRating = productRating;
        ProductRatingNumber = productRatingNumber;
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

    public Float getProductRating() {
        return ProductRating;
    }

    public void setProductRating(Float productRating) {
        ProductRating = productRating;
    }

    public String getProductRatingNumber() {
        return ProductRatingNumber;
    }

    public void setProductRatingNumber(String productRatingNumber) {
        ProductRatingNumber = productRatingNumber;
    }
}
