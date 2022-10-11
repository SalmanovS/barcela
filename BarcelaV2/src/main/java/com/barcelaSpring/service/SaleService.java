package com.barcelaSpring.service;

import com.barcelaSpring.entity.Sales;

import java.util.List;

public interface SaleService {

    void saveSales(Sales sales);

    public List<String> showAllSales();

    public List<String> showTodaySales();

    public List<Sales> infoOrder(String orderSales);

    public void removeProductFromSales(int idSales);

    public Sales getInfoSalesById(int idSales);

}
