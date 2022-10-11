package com.barcelaSpring.controller;


import com.barcelaSpring.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
    @Autowired
    ReportsService reportsService;

    @RequestMapping("/")
    public String homePage(Model model){
        double today = reportsService.revenueToday();
        double yesterday = reportsService.revenueYesterday();
        model.addAttribute("today",today);
        model.addAttribute("yesterday",yesterday);
        return "home";
    }
}
