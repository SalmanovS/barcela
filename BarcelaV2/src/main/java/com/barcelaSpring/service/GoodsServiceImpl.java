package com.barcelaSpring.service;

import com.barcelaSpring.dao.GoodsDAO;
import com.barcelaSpring.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsDAO goodsDAO;

    @Override
    @Transactional
    public List<Goods> getShowAllGoods() {
        return goodsDAO.getShowAllGoods();
    }

    @Override
    @Transactional
    public void saveGoods(Goods goods) {
        goodsDAO.saveGoods(goods);
    }

    @Override
    @Transactional
    public Goods getInfoGoods(int id) {
        return goodsDAO.getInfoGoods(id);
    }

    @Override
    @Transactional
    public void deleteGoods(int id) {
        goodsDAO.deleteGoods(id);
    }

    @Override
    @Transactional
    public Goods searchByBarcode(String barcode) {
        return goodsDAO.searchByBarcode(barcode);
    }

    @Override
    @Transactional
    public List<Goods> searchByBarcodeToList(String barcode) {
        return goodsDAO.searchByBarcodeToList(barcode);
    }

    @Override
    @Transactional
    public List<Goods> searchByProductName(String productName) {
        return goodsDAO.searchByProductName(productName);
    }
}
