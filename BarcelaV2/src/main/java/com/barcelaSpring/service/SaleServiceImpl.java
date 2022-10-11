package com.barcelaSpring.service;

import com.barcelaSpring.dao.SalesDAO;
import com.barcelaSpring.entity.Sales;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SalesDAO salesDAO;

    @Override
    @Transactional
    public void saveSales(Sales sales) {
        salesDAO.saveSales(sales);
    }

    @Override
    @Transactional
    public List<String> showAllSales() {
        return salesDAO.showAllSales();
    }

    @Override
    @Transactional
    public List<String> showTodaySales() {
        return salesDAO.showTodaySales();
    }

    @Override
    @Transactional
    public List<Sales> infoOrder(String orderSales) {
        return salesDAO.infoOrder(orderSales);
    }

    @Override
    @Transactional
    public void removeProductFromSales(int idSales) {
        salesDAO.removeProductFromSales(idSales);
    }

    @Override
    @Transactional
    public Sales getInfoSalesById(int idSales) {
        return salesDAO.getInfoSalesById(idSales);
    }


}
