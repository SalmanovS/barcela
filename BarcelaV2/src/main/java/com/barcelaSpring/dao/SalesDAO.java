package com.barcelaSpring.dao;

import com.barcelaSpring.entity.Sales;

import java.util.List;

public interface SalesDAO {
    void saveSales(Sales sales);



    List<String> showAllSales();

    List<Sales> infoOrder(String orderSales);

    void removeProductFromSales(int idSales);

    Sales getInfoSalesById(int idSales);

    List<String> showTodaySales();
}
