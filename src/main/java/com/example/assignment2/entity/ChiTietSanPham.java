package com.example.assignment2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="ChiTietSP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdSP",referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx",referencedColumnName = "Id")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "IdMauSac",referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP",referencedColumnName = "Id")
    private DongSanPham dongSanPham;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;
}
