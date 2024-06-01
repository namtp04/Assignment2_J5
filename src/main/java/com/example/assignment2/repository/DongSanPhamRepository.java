package com.example.assignment2.repository;

import com.example.assignment2.entity.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSanPhamRepository extends JpaRepository<DongSanPham, UUID> {

}
