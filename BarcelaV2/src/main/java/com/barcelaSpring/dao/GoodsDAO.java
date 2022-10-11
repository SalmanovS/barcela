package com.barcelaSpring.dao;

import com.barcelaSpring.entity.Goods;

import java.util.List;

public interface GoodsDAO {

    List<Goods> getShowAllGoods();

    void saveGoods(Goods goods);

    Goods getInfoGoods(int id);

    void deleteGoods(int id);


    Goods searchByBarcode(String barcode);

    List<Goods> searchByBarcodeToList(String barcode);

    List<Goods> searchByProductName(String productName);
}
