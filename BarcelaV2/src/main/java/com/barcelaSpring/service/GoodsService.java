package com.barcelaSpring.service;

import com.barcelaSpring.entity.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> getShowAllGoods();

    void saveGoods(Goods goods);

     Goods getInfoGoods(int id);

     void deleteGoods(int id);

     Goods searchByBarcode(String barcode);

     List<Goods> searchByBarcodeToList(String barcode);

     List<Goods> searchByProductName(String productName);
}
