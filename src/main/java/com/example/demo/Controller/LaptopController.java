package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LaptopService;
import com.example.demo.dto.Laptop;
import com.example.demo.dto.ResponseStructure;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/laptop")
public class LaptopController 
{
	@Autowired
    private LaptopService ser;
	@PostMapping("/{id}")
	public ResponseEntity<ResponseStructure<Laptop>> saveLaptop(@RequestBody Laptop laptop,@PathVariable int id)
	{
		return ser.saveLaptop(laptop, id);
	}
    @GetMapping("/findbybrand")
    public ResponseEntity<ResponseStructure<List<Laptop>>>findByBrand(@RequestParam String brand) 
    {
       return ser.findByBrand(brand);
    }
    @PutMapping("/")
    public ResponseEntity<ResponseStructure<Laptop>> updateLaptop(@RequestBody Laptop laptop)
    {
    	return ser.updateLaptop(laptop);
    }
    
}
