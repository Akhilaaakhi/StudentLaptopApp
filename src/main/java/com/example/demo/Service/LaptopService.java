package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LaptopDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dto.Laptop;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.dto.Student;

@Service
public class LaptopService 
{
	@Autowired
   private LaptopDao ldao;
	@Autowired
	private StudentDao sdao;
	
	public ResponseEntity<ResponseStructure<Laptop>> saveLaptop(Laptop lap,int student_id)
	{
	Optional<Student> recstu=sdao.findById(student_id);
    ResponseStructure<Laptop> structure=new ResponseStructure<>();
	if(recstu.isPresent())
     {
	  Student student=recstu.get();
	  lap.setStudent(student);
	  structure.setData(ldao.saveLaptop(lap));
	  structure.setMessage("laptop is assigned to student");
	  structure.setStatuscode(HttpStatus.CREATED.value());
      return new ResponseEntity<ResponseStructure<Laptop>>(structure,HttpStatus.CREATED);
     }
	return null;
	}
	
	public ResponseEntity<ResponseStructure<List<Laptop>>> findByBrand(String brand)
	{
		ResponseStructure<List<Laptop>> structure=new ResponseStructure<>();
		structure.setData(ldao.findByBrand(brand));
		structure.setMessage("found by brand");
		structure.setStatuscode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<Laptop>>>(structure,HttpStatus.OK);	
	}
	
	public ResponseEntity<ResponseStructure<Laptop>> updateLaptop(Laptop laptop)
	{
		Optional<Laptop> lap=ldao.findById(laptop.getSno());
		ResponseStructure<Laptop> structure= new ResponseStructure<Laptop>();
		if(lap.isPresent())
		{
			Laptop top=lap.get();
			top.setSno(laptop.getSno());
			top.setBrand(laptop.getBrand());
			top.setLname(laptop.getLname());
			top.setGeneration(laptop.getGeneration());
			structure.setMessage("Laptop id Updated");
			structure.setData(ldao.saveLaptop(top));
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Laptop>> (structure, HttpStatus.ACCEPTED);
		}
		return null;
	}

}

