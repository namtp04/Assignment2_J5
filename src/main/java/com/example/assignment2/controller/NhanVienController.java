package com.example.assignment2.controller;

import com.example.assignment2.entity.ChucVu;
import com.example.assignment2.entity.NhanVien;
import com.example.assignment2.repository.NhanVienRepository;
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
@RequestMapping("/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("list")
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0")Integer page){
        model.addAttribute("lstNV",phanTrang(page,model));
        return "/nhanvien/list";
    }

    private List<NhanVien> phanTrang(Integer currentPage, Model model) {
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<NhanVien> nhanVienPage = nhanVienRepository.findAll(pageable);
        model.addAttribute("numpage", nhanVienPage.getTotalPages());
        model.addAttribute("currentPage", currentPage);
        return nhanVienPage.getContent();
    }
}
