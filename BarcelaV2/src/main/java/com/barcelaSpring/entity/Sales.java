package com.barcelaSpring.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSales")
    private int idSales;

    @Column(name = "productBarcode")
    private String productBarcode;

    @Column(name = "productName")
    private String productName;

    @Column(name="brand")
    private String productBrand;



    @Column(name = "count")
    private int productCount;

    @Column(name = "productPrice")
    private double productPrice;

    @Column(name = "total")
    private double totalPrice;

    @Column(name = "dateSale")
    private  LocalDateTime dateSale;

    @Column(name = "orderSales")
    private String orderSales;

    public Sales() {
    }

    public Sales(String productBarcode, String productName, String productBrand, int productCount, double productPrice, double totalPrice,  LocalDateTime dateSale, String orderSales) {
        this.productBarcode = productBarcode;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productCount = productCount;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
        this.dateSale = dateSale;
        this.orderSales = orderSales;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public int getIdSales() {
        return idSales;
    }

    public void setIdSales(int idSales) {
        this.idSales = idSales;
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



    public  LocalDateTime getDateSale() {
        return dateSale;
    }

    public void setDateSale( LocalDateTime dateSale) {
        this.dateSale = dateSale;
    }

    public String getOrderSales() {
        return orderSales;
    }

    public void setOrderSales(String orderSales) {
        this.orderSales = orderSales;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "idSales=" + idSales +
                ", productBarcode='" + productBarcode + '\'' +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productCount=" + productCount +
                ", productPrice=" + productPrice +
                ", totalPrice=" + totalPrice +
                ", dateSale=" + dateSale +
                ", orderSales='" + orderSales + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return Objects.equals(productBarcode, sales.productBarcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productBarcode);
    }
}