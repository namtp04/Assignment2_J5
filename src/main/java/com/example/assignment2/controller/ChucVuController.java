package com.example.assignment2.controller;

import com.example.assignment2.entity.ChucVu;
import com.example.assignment2.entity.DongSanPham;
import com.example.assignment2.repository.ChucVuRepository;
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
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping("list")
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0")Integer page){
        model.addAttribute("lstCV",phanTrang(page,model));
        return "/chucvu/list";
    }

    private List<ChucVu> phanTrang(Integer currentPage, Model model) {
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<ChucVu> chucVuPage = chucVuRepository.findAll(pageable);
        model.addAttribute("numpage", chucVuPage.getTotalPages());
        model.addAttribute("currentPage", currentPage);
        return chucVuPage.getContent();
    }
}
