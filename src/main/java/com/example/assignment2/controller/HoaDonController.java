package com.example.assignment2.controller;

import com.example.assignment2.entity.HoaDon;
import com.example.assignment2.entity.HoaDonChiTiet;
import com.example.assignment2.repository.HoaDonChiTietRepository;
import com.example.assignment2.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/bill")
public class HoaDonController {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @GetMapping("/list")
    public String hienThi(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        model.addAttribute("lstHD", phanTrang(page, model));
        return "/hoadon/list";
    }

    @GetMapping("/detail/{ma}")
    public String detail(@PathVariable("ma") UUID ma, Model model) {
        List<HoaDonChiTiet> lstHDCT = hoaDonChiTietRepository.findByIdHoaDon(ma);
        model.addAttribute("hd", hoaDonRepository.findById(ma).get());
        model.addAttribute("lstSP", lstHDCT);
        BigDecimal tongTien = BigDecimal.ZERO;
        for (HoaDonChiTiet hoaDonChiTiet: lstHDCT) {
            if (hoaDonChiTiet.getDonGia() != null) {
                tongTien = tongTien.add(hoaDonChiTiet.getDonGia());
            }
        }
        model.addAttribute("tongTien", tongTien);
        return "/hoadon/detail";
    }

    private List<HoaDon> phanTrang(Integer currentPage, Model model) {
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<HoaDon> hoaDonPage = hoaDonRepository.findAll(pageable);
        model.addAttribute("numpage", hoaDonPage.getTotalPages());
        model.addAttribute("currentPage", currentPage);
        return hoaDonPage.getContent();
    }
}
