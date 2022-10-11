package com.barcelaSpring.dao;

import com.barcelaSpring.entity.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesDAOImpl implements SalesDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveSales(Sales sales) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(sales);
    }

    @Override
    public List<String> showAllSales() {
        Session session = sessionFactory.getCurrentSession();

       Query salesList = session.createQuery("select distinct orderSales from Sales ");
        List<String> list = salesList.list();
        return list;
    }

    @Override
    public List<Sales> infoOrder(String orderSales) {
        Session session = sessionFactory.getCurrentSession();
        Query salesList = session.createQuery("from Sales where orderSales = :order").
                setParameter("order", orderSales);
        List<Sales> list = salesList.getResultList();
        return list;
    }

    @Override
    public void removeProductFromSales(int idSales) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Sales where idSales = :id").setParameter("id",idSales).executeUpdate();
    }

    @Override
    public Sales getInfoSalesById(int idSales) {
        Session session = sessionFactory.getCurrentSession();
        Sales sales = session.get(Sales.class, idSales);
        return sales;
    }

    @Override
    public List<String> showTodaySales() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select distinct orderSales from Sales where date(dateSale) = curdate()").list();
    }


}
