package com.barcelaSpring.controller;

import com.barcelaSpring.entity.Goods;
import com.barcelaSpring.entity.Sales;
import com.barcelaSpring.service.GoodsService;
import com.barcelaSpring.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/sales/")
public class SalesController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SaleService saleService;


    @RequestMapping("index")
    public String index(){
        return "saleIndex";
    }

    @RequestMapping("addNewSales")
    public String newSalesPage(Model model){
        List<Goods> goodsList = goodsService.getShowAllGoods();
        model.addAttribute("allGoods",goodsList);
        return "addNewSales";
    }

    @ResponseBody
    @RequestMapping("newSale")
    public Goods addSale(@RequestParam("barcode") String barcode){
        Goods  goods= goodsService.searchByBarcode(barcode);
        return goods;
    }


    @ResponseBody
    @RequestMapping("checkProduct")
    public boolean checkProduct(@RequestParam("prodBarcode") String shtrix, @RequestParam("quantity") int count){
        Goods goods = goodsService.searchByBarcode(shtrix);
        if(goods.getProductCount()>= count){
           return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("saveSales")
    public String saveSales(@RequestParam("shtrixCode") String barcode, @RequestParam("prodQuantity") int productCount,
                             @RequestParam("prodTotal") double productTotal){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of( "Europe/Moscow" ));
        Goods goods = goodsService.searchByBarcode(barcode);

        String order = String.valueOf(localDateTime.getDayOfMonth() +""+ localDateTime.getMonthValue() +""+ localDateTime.getYear() +""+
                localDateTime.getHour() +""+localDateTime.getMinute() +""+ localDateTime.getSecond());

        Sales sales = new Sales(barcode,goods.getProductName(), goods.getProductBrand(), productCount,
                goods.getProductPrice(), productTotal, localDateTime, order);
        goods.setProductCount(goods.getProductCount() - productCount);
        goodsService.saveGoods(goods);
        saleService.saveSales(sales);
        return "redirect: addNewSales";
    }


    @RequestMapping("searchSales")
    public String searchSales(Model model){
        List<String> showAllSales = saleService.showAllSales();
        List<String> showTodaySales = saleService.showTodaySales();
        model.addAttribute("showAllSales",showAllSales);
        model.addAttribute("showTodaySales",showTodaySales);
        return "searchSales";
    }

    @RequestMapping("orderInfo")
    public String orderInfo(@RequestParam ("orderSales") String orderSales, Model model){
        List<Sales> salesList = saleService.infoOrder(orderSales);
        model.addAttribute("salesList", salesList);
        return "orderInfo";
    }

    @RequestMapping("deleteProductFromSales")
    public String deleteProductFromSales(@RequestParam("idSales") int idSales){
        Sales sales = saleService.getInfoSalesById(idSales);
        Goods goods = goodsService.searchByBarcode(sales.getProductBarcode());
        goods.setProductCount(goods.getProductCount() + sales.getProductCount());
        saleService.removeProductFromSales(idSales);
        goodsService.saveGoods(goods);
        return "redirect: searchSales";
    }
}
