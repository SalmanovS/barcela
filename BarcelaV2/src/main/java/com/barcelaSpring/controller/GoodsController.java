package com.barcelaSpring.controller;

import com.barcelaSpring.entity.Goods;
import com.barcelaSpring.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/goods/")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("showAllGoods")
    public String showAllGoods(Model model){
        List<Goods> goods = goodsService.getShowAllGoods();
        model.addAttribute("showGoods",goods);
        return "showAllGoods";
    }

    @RequestMapping("addNewGoods")
    public String addNewGoods(Model model){
        Goods goods = new Goods();
        model.addAttribute("addNewGoods", goods);
        return "addNewGoods";
    }

    @RequestMapping("saveGoods")
    public String saveGoods(@ModelAttribute("addNewGoods") Goods goods ){
        Goods goodsSearch = goodsService.searchByBarcode(goods.getProductBarcode());
        if(goodsSearch == null){
            goodsService.saveGoods(goods);
        }else {
            return "404Page";
        }

        return "redirect: showAllGoods";
    }

    @RequestMapping("updateGoods")
    public String updateGoods(@RequestParam("goodproductId") int id, Model model){
        Goods goods = goodsService.getInfoGoods(id);
        model.addAttribute("addNewGoods", goods);
        return "addNewGoods";
    }

    @RequestMapping("deleteGoods")
    public String deleteGoods(@RequestParam("goodproductId") int id){
        goodsService.deleteGoods(id);

        return "redirect: showAllGoods";
    }

    @RequestMapping("addNewGoodsByBarcode")
    public String addNewSales(Model model){
        List<Goods> goodsList = goodsService.getShowAllGoods();
        model.addAttribute("allGoods", goodsList);
        return "addGoodsByBarcode";
    }
    @RequestMapping("addGoodsByBarcode")
    public String addGoodsByBarcode(@RequestParam("enteredBarcode") String barcode, Model model){
        Goods goods = goodsService.searchByBarcode(barcode);
        model.addAttribute("byBarcode", goods);
        List<Goods> goodsList = goodsService.getShowAllGoods();
        model.addAttribute("allGoods", goodsList);
        return "addGoodsByBarcode";
    }


    @RequestMapping("saveGoodsByBarcode")
    public String saveGoodsByBarcode(@RequestParam("productBarcode")String barcode,
                                     @RequestParam("countForAddByBarcode") int productCount, Model model){
            Goods goods = goodsService.searchByBarcode(barcode);
            if(goods == null){
                List<Goods> goodsList = goodsService.getShowAllGoods();
                model.addAttribute("allGoods", goodsList);
                return "addGoodsByBarcode";
            }else {
                goods.setProductCount(goods.getProductCount() + productCount);
                goodsService.saveGoods(goods);
                model.addAttribute("showGoodsByBarcode", goods);
                List<Goods> goodsList = goodsService.getShowAllGoods();
                model.addAttribute("allGoods", goodsList);
            }
        return "addGoodsByBarcode";
    }

    @RequestMapping("searchProducts")
    public String searchProduct(){
        return "searchProduct";
    }

    @RequestMapping("searchByBarcode")
    public String searchByBarcodeList(@RequestParam("searchBarcode")String barcode, Model model){
        List<Goods> goodsList = goodsService.searchByBarcodeToList(barcode);
        model.addAttribute("productList", goodsList);
        return "searchProduct";
    }

    @RequestMapping("searchByProductName")
    public String searchByProductName(@RequestParam("productName")String productName, Model model){
            List<Goods> goodsList = goodsService.searchByProductName(productName);
            model.addAttribute("productList", goodsList);

        return "searchProduct";
    }


}
