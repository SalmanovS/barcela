package com.barcelaSpring.service;

import com.barcelaSpring.dao.ReportsDAO;
import com.barcelaSpring.entity.Goods;
import com.barcelaSpring.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportsServiceImpl implements ReportsService{
    @Autowired
    private ReportsDAO reportsDAO;

    @Override
    @Transactional
    public List<Sales> goodsSoldToday() {
        return reportsDAO.goodsSoldToday();
    }

    @Override
    @Transactional
    public List<Sales> goodsSoldWeek() {
        return reportsDAO.goodsSoldWeek();
    }

    @Override
    @Transactional
    public List<Sales> goodsSoldMonth() {
        return reportsDAO.goodsSoldMonth();
    }

    @Override
    @Transactional
    public List<Sales> goodsSoldYear() {
        return reportsDAO.goodsSoldYear();
    }

    @Override
    @Transactional
    public Long numberOfProductsSoldToday() {
        return reportsDAO.numberOfProductsSoldToday();
    }

    @Override
    @Transactional
    public Long numberOfProductsSoldWeek() {
        return reportsDAO.numberOfProductsSoldWeek();
    }

    @Override
    @Transactional
    public Long numberOfProductsSoldMonth() {
        return reportsDAO.numberOfProductsSoldMonth();
    }

    @Override
    @Transactional
    public Long numberOfProductsSoldYear() {
        return reportsDAO.numberOfProductsSoldYear();
    }

    @Override
    @Transactional
    public double revenueToday() {
        return reportsDAO.revenueToday();
    }

    @Override
    @Transactional
    public double revenueYesterday() {
        return reportsDAO.revenueYesterday();
    }

    @Override
    @Transactional
    public double revenueWeek() {
        return reportsDAO.revenueWeek();
    }

    @Override
    @Transactional
    public double revenueMonth() {
        return reportsDAO.revenueMonth();
    }

    @Override
    @Transactional
    public double revenueYear() {
        return reportsDAO.revenueYear();
    }


}
