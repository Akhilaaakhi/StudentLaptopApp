package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Student;
import com.example.demo.repository.StudentRepository;

@Repository
public class StudentDao
{
	@Autowired
   private StudentRepository repo;
	
	public Student saveStudent(Student student)
	{
		return repo.save(student);
	}
	
	public Optional<Student> findById(int id)
	{
		return repo.findById(id);
	}

	public Optional<Student> verifyByEmail(String email, String password) 
	{
		return repo.verifyByEmail(email, password);
	}
	public Optional<Student> verifyByPhone(long phone, String password) 
	{
		return repo.verifyByPhone(phone, password);
	}
	public boolean deleteById(int id)
	{
		Optional<Student> stu=repo.findById(id);
		if(stu.isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
			
	}
}
