package com.example.assignment2.repository;

import com.example.assignment2.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    Boolean existsByMaAndAndMatKhau(String username, String password);
    @Query("select c from NhanVien c where c.ma=:ma and c.trangThai= 1")
    NhanVien getNhanVienAdmin(@Param("ma")String ma);
}
