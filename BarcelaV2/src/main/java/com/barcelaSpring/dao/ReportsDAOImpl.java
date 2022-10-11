package com.barcelaSpring.dao;

import com.barcelaSpring.entity.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReportsDAOImpl implements ReportsDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Sales> goodsSoldToday() {
        Session session = sessionFactory.getCurrentSession();
        List<Sales> salesList = session.createQuery("from Sales where date(dateSale) = curdate()").getResultList();
        return salesList;
    }

    @Override
    public List<Sales> goodsSoldWeek() {
        Session session = sessionFactory.getCurrentSession();
        List<Sales> salesList = session.createQuery("from Sales where year(dateSale) = year(now()) and week(dateSale) = week(now())")
                .getResultList();
        return salesList;
    }

    @Override
    public List<Sales> goodsSoldMonth() {
        Session session = sessionFactory.getCurrentSession();
        List<Sales> salesList = session.createQuery("from Sales where month(dateSale) = month(now()) and year(dateSale)= year(now())")
                .getResultList();
        return salesList;
    }

    @Override
    public List<Sales> goodsSoldYear() {
        Session session = sessionFactory.getCurrentSession();
        List<Sales> salesList = session.createQuery("from Sales where year(dateSale) = year(now())").getResultList();

        return salesList;
    }

    @Override
    public Long numberOfProductsSoldToday() {
        Session session = sessionFactory.getCurrentSession();
        Integer qty = 0;
        Long count = (Long) session.createQuery("select sum(productCount) from Sales  where date(dateSale) = curdate()").uniqueResult();
        if(count == null){
            count = Long.valueOf(qty);
        }


        return count;
    }

    @Override
    public Long numberOfProductsSoldWeek() {
        Session session = sessionFactory.getCurrentSession();
        Integer qty= 0;
        Long count = (Long) session.createQuery("select sum(productCount) from Sales where year(dateSale) = year(now()) and week(dateSale) = week(now())")
                .uniqueResult();
        if(count == null){
            count = Long.valueOf(qty);
        }
        return count;
    }

    @Override
    public Long numberOfProductsSoldMonth() {
        Session session = sessionFactory.getCurrentSession();
        Integer qty = 0;
        Long count = (Long) session.createQuery("select sum(productCount) from Sales where month(dateSale) = month(now()) and year(dateSale)= year(now())")
                .uniqueResult();
        if(count == null){
            count = Long.valueOf(qty);
        }
        return count;
    }

    @Override
    public Long numberOfProductsSoldYear() {
        Session session = sessionFactory.getCurrentSession();
        Integer qty = 0;
        Long count = (Long) session.createQuery("select sum(productCount) from Sales where year(dateSale) = year(now())")
                .uniqueResult();
        if(count == null){
            count = Long.valueOf(qty);
        }
        return count;
    }

    @Override
    public double revenueToday() {
        Session session = sessionFactory.getCurrentSession();
        Double total = (Double) session.createQuery("select sum(totalPrice) from Sales where date(dateSale) = curdate()").uniqueResult();
        double defaultTotal = 0.0;
        if(total == null){
            total = defaultTotal;
        }

        total = Math.round(total * 100) / 100.0;
        return total;
    }

    @Override
    public double revenueYesterday() {
        Session session = sessionFactory.getCurrentSession();
        Double total = (Double) session.createQuery("select sum(totalPrice) from Sales  where date(dateSale) = curdate() -1").uniqueResult();
        double defaultTotal = 0.0;
        if(total == null){
            total = defaultTotal;
        }

        total = Math.round(total * 100) / 100.0;
        return total;
    }

    @Override
    public double revenueWeek() {
        Session session = sessionFactory.getCurrentSession();
        double defaultResult = 0.0;
        Double total = (Double) session.createQuery("select sum(totalPrice) from Sales  where year(dateSale) = year(now()) and week(dateSale) = week(now())")
                .uniqueResult();
        if(total == null){
            total = defaultResult;
        }
        total = Math.round(total * 100) / 100.0;
        return total;
    }

    @Override
    public double revenueMonth() {
        Session session = sessionFactory.getCurrentSession();

        double defaultTotal = 0.0;
        Double total = (Double) session.createQuery("select sum(totalPrice) from Sales  where month(dateSale) = month(now()) and year(dateSale)= year(now())").uniqueResult();
        if(total == null){
            total = defaultTotal;
        }
        total = Math.round(total * 100) / 100.0;
        return total;
    }

    @Override
    public double revenueYear() {
        Session session = sessionFactory.getCurrentSession();
        double defaultTotal = 0.0;
        Double total = (Double) session.createQuery("select sum(totalPrice) from Sales where year(dateSale) = year(now())").uniqueResult();
        if(total == null){
            total = defaultTotal;
        }
        total = Math.round(total * 100) / 100.0;
        return total;
    }


    public void addQuantityOfProductsTheTable(List<Sales> result, List<Sales> newList){
        for (Sales sales: result) {
            if(newList.contains(sales)){
                for (Sales list1: newList) {
                    if(list1.equals(sales)){
                        list1.setProductCount(list1.getProductCount()+ sales.getProductCount());
                    }
                }
            }else {
                newList.add(sales);
            }
        }

    }



}
