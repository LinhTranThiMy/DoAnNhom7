package com.example.model;

public class MyOrder {
    private String txttrack;
    private String txttrackNumber;
    private String txtName;
    private String txtApple;
    private String txtType;
    private String txtQuantity;
    private String txtStatus;
    private String txtBought;
    private String txtTotal;
    private double txtPrice;
    private int imvcase;
    private int imvbag;

    public MyOrder(String txttrack, String txttrackNumber, String txtName, String txtApple, String txtType, String txtQuantity, String txtStatus, String txtBought, String txtTotal, double txtPrice, int imvcase, int imvbag) {
        this.txttrack = txttrack;
        this.txttrackNumber = txttrackNumber;
        this.txtName = txtName;
        this.txtApple = txtApple;
        this.txtType = txtType;
        this.txtQuantity = txtQuantity;
        this.txtStatus = txtStatus;
        this.txtBought = txtBought;
        this.txtTotal = txtTotal;
        this.txtPrice = txtPrice;
        this.imvcase = imvcase;
        this.imvbag = imvbag;
    }

    public String getTxttrack() {
        return txttrack;
    }

    public void setTxttrack(String txttrack) {
        this.txttrack = txttrack;
    }

    public String getTxttrackNumber() {
        return txttrackNumber;
    }

    public void setTxttrackNumber(String txttrackNumber) {
        this.txttrackNumber = txttrackNumber;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtApple() {
        return txtApple;
    }

    public void setTxtApple(String txtApple) {
        this.txtApple = txtApple;
    }

    public String getTxtType() {
        return txtType;
    }

    public void setTxtType(String txtType) {
        this.txtType = txtType;
    }

    public String getTxtQuantity() {
        return txtQuantity;
    }

    public void setTxtQuantity(String txtQuantity) {
        this.txtQuantity = txtQuantity;
    }

    public String getTxtStatus() {
        return txtStatus;
    }

    public void setTxtStatus(String txtStatus) {
        this.txtStatus = txtStatus;
    }

    public String getTxtBought() {
        return txtBought;
    }

    public void setTxtBought(String txtBought) {
        this.txtBought = txtBought;
    }

    public String getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(String txtTotal) {
        this.txtTotal = txtTotal;
    }

    public double getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(double txtPrice) {
        this.txtPrice = txtPrice;
    }

    public int getImvcase() {
        return imvcase;
    }

    public void setImvcase(int imvcase) {
        this.imvcase = imvcase;
    }

    public int getImvbag() {
        return imvbag;
    }

    public void setImvbag(int imvbag) {
        this.imvbag = imvbag;
    }
}
