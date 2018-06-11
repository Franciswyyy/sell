package com.imooc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @GetMapping("/")
    public ModelAndView list(){

    }
}
