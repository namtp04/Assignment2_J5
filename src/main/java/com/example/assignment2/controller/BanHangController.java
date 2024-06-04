package com.example.assignment2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/ban-hang")
public class BanHangController {
    @GetMapping("hien-thi")
    public String hienThi(){
        return "/banhang/banhang";
    }
}
