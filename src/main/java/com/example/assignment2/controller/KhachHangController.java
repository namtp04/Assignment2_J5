package com.example.assignment2.controller;

import com.example.assignment2.entity.DongSanPham;
import com.example.assignment2.entity.KhachHang;
import com.example.assignment2.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class KhachHangController {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("/list")
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0") Integer page){
        model.addAttribute("lstKH",phanTrang(page,model));
        return"/khachhang/list";
    }

    private List<KhachHang> phanTrang(Integer currentPage, Model model) {
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<KhachHang> khachHangPage = khachHangRepository.findAll(pageable);
        model.addAttribute("numpage", khachHangPage.getTotalPages());
        model.addAttribute("currentPage", currentPage);
        return khachHangPage.getContent();
    }
}
