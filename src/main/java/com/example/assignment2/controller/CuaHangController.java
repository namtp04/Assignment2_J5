package com.example.assignment2.controller;

import com.example.assignment2.entity.ChucVu;
import com.example.assignment2.entity.CuaHang;
import com.example.assignment2.repository.CuaHangRepository;
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
@RequestMapping("/cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangRepository cuaHangRepository;

    @GetMapping("list")
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0")Integer page){
        model.addAttribute("lstCH",phanTrang(page,model));
        return "/cuahang/list";
    }

    private List<CuaHang> phanTrang(Integer currentPage, Model model) {
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<CuaHang> cuaHangPage = cuaHangRepository.findAll(pageable);
        model.addAttribute("numpage", cuaHangPage.getTotalPages());
        model.addAttribute("currentPage", currentPage);
        return cuaHangPage.getContent();
    }
}
