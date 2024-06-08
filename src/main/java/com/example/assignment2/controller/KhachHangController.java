package com.example.assignment2.controller;

import com.example.assignment2.entity.DongSanPham;
import com.example.assignment2.entity.KhachHang;
import com.example.assignment2.entity.NhanVien;
import com.example.assignment2.repository.KhachHangRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @GetMapping("view-add")
    public String viewAdd() {
        return "/khachhang/add";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("kh") @Valid KhachHang khachHang, BindingResult bindingResult, Model model) {
        KhachHang sp = khachHangRepository.findKhachHangByMa(khachHang.getMa());
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",getErrorMessages(bindingResult));
            return "/khachhang/add";
        }
        if (sp != null) {
            model.addAttribute("error", "Mã đã tồn tại");
            return "/khachhang/add";
        }
        khachHangRepository.save(khachHang);
        return "redirect:/customer/list";
    }

    @GetMapping("view-update/{ma}")
    public String viewUpdate(Model model, @PathVariable("ma") UUID ma) {
        model.addAttribute("kh", khachHangRepository.findById(ma).get());
        return "/khachhang/update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("kh") @Valid KhachHang khachHang, BindingResult bindingResult, Model model) {
        KhachHang sp = khachHangRepository.findKhachHangByMa(khachHang.getMa());
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",getErrorMessages(bindingResult));
            model.addAttribute("nv", khachHangRepository.findById(khachHang.getId()).get());
            return "/khachhang/update";
        }
        if (sp != null && !sp.getId().equals(khachHang.getId())) {
            model.addAttribute("error", "Mã đã tồn tại");
            return "/khachhang/update";
        }
        khachHangRepository.save(khachHang);
        return "redirect:/customer/list";
    }

    private List<KhachHang> phanTrang(Integer currentPage, Model model) {
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<KhachHang> khachHangPage = khachHangRepository.findAll(pageable);
        model.addAttribute("numpage", khachHangPage.getTotalPages());
        model.addAttribute("currentPage", currentPage);
        return khachHangPage.getContent();
    }

    public Map<String, String> getErrorMessages(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }
}
