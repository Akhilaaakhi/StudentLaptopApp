package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> 
{
	@Query("select l from Laptop l where l.brand=?1")
    public List<Laptop> findByBrand(String brand);
}
