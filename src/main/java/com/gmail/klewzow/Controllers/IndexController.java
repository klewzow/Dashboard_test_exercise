package com.gmail.klewzow.Controllers;

import com.gmail.klewzow.Commons.ReaderCustomers;
import com.gmail.klewzow.Configurations.Services.CustomerService;
import com.gmail.klewzow.html.PageNavigation.Button;
import com.gmail.klewzow.html.PageNavigation.PageNavigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private CustomerService customerService;

    private ReaderCustomers customers;
    @Autowired
    private PageNavigation pageNavigation;

    @GetMapping("/")
    public String indexPage(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        pageNavigation.setValue(Integer.parseInt(customerService.statistic()) % 8);
        List<Button> btn = new ArrayList<>();
        btn = pageNavigation.btnGenerate(page);
        model.addAttribute("btn", btn);
        return "index";
    }

    @GetMapping("/index")
    public String defaultPage(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        System.out.println( Integer.parseInt(customerService.statistic()) /8)  ;
        pageNavigation.setValue(Integer.parseInt(customerService.statistic())/8);
        model.addAttribute("btn", pageNavigation.btnGenerate(page));
        return "index";
    }


}
