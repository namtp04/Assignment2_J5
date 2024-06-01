package com.example.assignment2.controller;

import com.example.assignment2.entity.DongSanPham;
import com.example.assignment2.entity.SanPham;
import com.example.assignment2.repository.DongSanPhamRepository;
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
@RequestMapping("/product-type")
public class DongSanPhamController {
    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @GetMapping("list")
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0") Integer page){
        model.addAttribute("lstLSP", phanTrang(page,model));
        return "/dongsanpham/list";
    }

    private List<DongSanPham> phanTrang(Integer currentPage, Model model) {
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<DongSanPham> dongSanPhamPage = dongSanPhamRepository.findAll(pageable);
        model.addAttribute("numpage", dongSanPhamPage.getTotalPages());
        model.addAttribute("currentPage", currentPage);
        return dongSanPhamPage.getContent();
    }
}
