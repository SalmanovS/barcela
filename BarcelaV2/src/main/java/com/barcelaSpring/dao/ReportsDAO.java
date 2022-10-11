package com.barcelaSpring.dao;

import com.barcelaSpring.entity.Goods;
import com.barcelaSpring.entity.Sales;

import java.util.List;

public interface ReportsDAO {
    List<Sales> goodsSoldToday();

    List<Sales> goodsSoldWeek();

    List<Sales> goodsSoldMonth();

    List<Sales> goodsSoldYear();

    Long numberOfProductsSoldToday();

    Long numberOfProductsSoldWeek();

    Long numberOfProductsSoldMonth();

    Long numberOfProductsSoldYear();

    double revenueToday();

    double revenueYesterday();

    double revenueWeek();

    double revenueMonth();

    double revenueYear();

    void addQuantityOfProductsTheTable(List<Sales> result, List<Sales> newList);

}
