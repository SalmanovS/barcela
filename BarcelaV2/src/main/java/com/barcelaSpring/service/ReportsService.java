package com.barcelaSpring.service;

import com.barcelaSpring.entity.Goods;
import com.barcelaSpring.entity.Sales;

import java.util.List;

public interface ReportsService {

    public List<Sales> goodsSoldToday();

    public List<Sales> goodsSoldWeek();

    public List<Sales> goodsSoldMonth();

    public List<Sales> goodsSoldYear();

    public Long numberOfProductsSoldToday();

    public Long numberOfProductsSoldWeek();

    public Long numberOfProductsSoldMonth();

    public Long numberOfProductsSoldYear();

    public double revenueToday();

    public double revenueYesterday();

    public double revenueWeek();

    public double revenueMonth();

    public double revenueYear();


}
