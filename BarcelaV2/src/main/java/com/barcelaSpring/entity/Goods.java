package com.barcelaSpring.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Goods {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "product_barcode")
    private String productBarcode;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_brand")
    private String productBrand;
    @Column(name = "product_count")
    private int productCount;
    @Column(name = "product_price")
    private double productPrice;

    public Goods() {
    }

    public Goods(String productBarcode, String productName, String productBrand, int productCount, double productPrice) {
        this.productBarcode = productBarcode;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productCount = productCount;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + productId +
                ", barcode=" + productBarcode +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productCount=" + productCount +
                ", productPrice=" + productPrice +
                '}';
    }
}