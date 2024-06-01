package com.example.assignment2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="NhanVien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;

    @Column(name="TenDem")
    private String tenDem;

    @Column(name="Ho")
    private String ho;

    @Column(name="GioiTinh")
    private String gioiTinh;

    @Column(name="NgaySinh")
    @Temporal(TemporalType.DATE)
    private String ngaySinh;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="Sdt")
    private String sdt;

    @Column(name="MatKhau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "IdCH",referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "IdCV",referencedColumnName = "id")
    private ChucVu chucVu;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
