package com.example.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productId;
    private String productThumb;
    private String productName;
    private double productPrice;
    private Float productRating;
    private String productRatingNumber;
    private String productDes;

    public Product() {
    }

    public Product(String productId, String productThumb, String productName, double productPrice, Float productRating, String productRatingNumber, String productDes) {
        this.productId = productId;
        this.productThumb = productThumb;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.productRatingNumber = productRatingNumber;
        this.productDes = productDes;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(String productThumb) {
        this.productThumb = productThumb;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Float getProductRating() {
        return productRating;
    }

    public void setProductRating(Float productRating) {
        this.productRating = productRating;
    }

    public String getProductRatingNumber() {
        return productRatingNumber;
    }

    public void setProductRatingNumber(String productRatingNumber) {
        this.productRatingNumber = productRatingNumber;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }
}
