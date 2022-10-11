package com.barcelaSpring.controller;


import com.barcelaSpring.dao.ReportsDAO;
import com.barcelaSpring.dao.SalesDAO;
import com.barcelaSpring.entity.Sales;
import com.barcelaSpring.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("reports")
public class ReportsController {

    @Autowired
    private ReportsService reportsService;

    @Autowired
    private ReportsDAO reportsDAO;

    @RequestMapping("reportsForToday")
    public String reportsForToday(Model model){
        List<Sales> result = reportsService.goodsSoldToday();
        List<Sales> newList = new ArrayList<>();
        reportsDAO.addQuantityOfProductsTheTable(result, newList);
        Long quantityProductsSold =  reportsService.numberOfProductsSoldToday();
        double revenueToday = reportsService.revenueToday();
        model.addAttribute("quantityProductsSold",quantityProductsSold);
        model.addAttribute("showGoodsSoldToday", newList);
        model.addAttribute("revenueToday", revenueToday);
        return "reportsForToday";
    }

    @RequestMapping("reportsForWeek")
    public String reportsForWeek(Model model){
        List<Sales> resultWeek = reportsService.goodsSoldWeek();
        List<Sales> newListWeek = new ArrayList<>();
        reportsDAO.addQuantityOfProductsTheTable(resultWeek, newListWeek);
        Long quantityProductsSoldWeek = reportsService.numberOfProductsSoldWeek();
        double revenueWeek = reportsService.revenueWeek();
        model.addAttribute("quantityProductsSoldWeek",quantityProductsSoldWeek );
        model.addAttribute("showGoodsSoldWeek", newListWeek);
        model.addAttribute("revenueWeek", revenueWeek);
        return "reportsForWeek";
    }

    @RequestMapping("reportsForMonth")
    public String reportsForMonth(Model model){
        List<Sales> resultMonth = reportsService.goodsSoldMonth();
        List<Sales> newListMonth = new ArrayList<>();
        reportsDAO.addQuantityOfProductsTheTable(resultMonth, newListMonth);
        Long quantityProductsSoldMonth = reportsService.numberOfProductsSoldMonth();
        double revenueMonth = reportsService.revenueMonth();
        model.addAttribute("showGoodsSoldMonth", newListMonth);
        model.addAttribute("quantityProductsSoldMonth",quantityProductsSoldMonth);
        model.addAttribute("revenueMonth", revenueMonth);
        return "reportsForMonth";
    }

    @RequestMapping("reportsForYear")
    public String reportsForYear(Model model){
        List<Sales> resultYear = reportsService.goodsSoldYear();
        List<Sales> newListYear = new ArrayList<>();
        reportsDAO.addQuantityOfProductsTheTable(resultYear, newListYear);
        Long quantityProductsSoldYear = reportsService.numberOfProductsSoldYear();
        double revenueYear = reportsService.revenueYear();
        model.addAttribute("showGoodsSoldYear",newListYear);
        model.addAttribute("quantityProductsSoldYear", quantityProductsSoldYear );
        model.addAttribute("revenueYear", revenueYear);
        return "reportsForYear";
    }


}
