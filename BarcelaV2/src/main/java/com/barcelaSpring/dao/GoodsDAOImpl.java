package com.barcelaSpring.dao;

import com.barcelaSpring.entity.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GoodsDAOImpl implements GoodsDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveGoods(Goods goods) {
        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(goods);
    }

    @Override
    public Goods getInfoGoods(int id) {
        Session session = sessionFactory.getCurrentSession();
        Goods goods = session.get(Goods.class,id);
        return goods;
    }

    @Override
    public void deleteGoods(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Goods where productId =:id")
                .setParameter("id", id).executeUpdate();
    }


    @Override
    public Goods searchByBarcode(String barcode) {
        Session session = sessionFactory.getCurrentSession();
        Goods goods = (Goods) session.createQuery("from Goods where productBarcode= :barcode")
                .setParameter("barcode", barcode).uniqueResult();
        return goods;

    }

    @Override
    public List<Goods> searchByBarcodeToList(String barcode) {
        Session session = sessionFactory.getCurrentSession();
        List<Goods> goodsList= session.createQuery("from Goods where productBarcode= :barcode")
                .setParameter("barcode", barcode).getResultList();
        return goodsList;
    }

    @Override
    public List<Goods> searchByProductName(String productName) {
        Session session = sessionFactory.getCurrentSession();
        List<Goods> goodsList = session.createQuery("from Goods where productName like :productName or "+
                        "productBarcode like :productName or productBrand like :productName")
                .setParameter("productName","%" + productName + "%").getResultList();
        return goodsList;
    }

    @Override
    public List<Goods> getShowAllGoods() {
        Session session = sessionFactory.getCurrentSession();
        List<Goods> goodsList =session.createQuery("from Goods ORDER BY productId DESC", Goods.class).getResultList();
        return  goodsList;
    }
}
