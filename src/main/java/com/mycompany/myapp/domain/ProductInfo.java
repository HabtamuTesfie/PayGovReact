package com.mycompany.myapp.domain;

public class ProductInfo {

    String productName;
    Long productPrice;
    String productOwner;
    String expireDate;

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public String geProductOwner() {
        return productOwner;
    }
    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public String getExpireDate() {
        return expireDate;
    }
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }


    public ProductInfo(String productName, Long productPrice, String productOwner, String expireDate) {
        super();
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOwner = productOwner;
        this.expireDate = expireDate;
    }

    public ProductInfo() {}







}
