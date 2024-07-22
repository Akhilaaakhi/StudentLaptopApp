package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Laptop;
import com.example.demo.repository.LaptopRepository;

@Repository
public class LaptopDao 
{
	@Autowired
   private LaptopRepository repo;
	public Laptop saveLaptop(Laptop laptop)
	{
		return repo.save(laptop);
	}
	public Optional<Laptop> findById(int id)
	{
		return repo.findById(id);
	}
	public List<Laptop> findByBrand(String brand)
	{
		return repo.findByBrand(brand);
	}
}
