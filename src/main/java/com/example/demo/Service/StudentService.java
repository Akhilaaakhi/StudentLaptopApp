package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.InValidCredentialException;
import com.example.demo.dao.StudentDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.dto.Student;

@Service
public class StudentService 
{  
	@Autowired
	private StudentDao dao;
   
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student)
	{
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		structure.setMessage("Student is saved");
		structure.setData(dao.saveStudent(student));
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Student>> findById(int id)
	{
		Optional<Student> stu=dao.findById(id);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		if(stu.isPresent())
		{
		structure.setMessage(" Find Student id ");
		structure.setData(stu.get());
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
	}
		throw new InValidCredentialException();
  }
	public ResponseEntity<ResponseStructure<Student>> verifyByEmail(String email,String password)
	{
		Optional<Student> stu=dao.verifyByEmail(email, password);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		if(stu.isPresent()) 
		{
		structure.setMessage(" verify Student email" );
		structure.setData(stu.get());
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}
		throw new InValidCredentialException();
  }
	public ResponseEntity<ResponseStructure<Student>> verifyByPhone(long phone,String password)
	{
		Optional<Student> stu=dao.verifyByPhone(phone, password);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		if(stu.isPresent()) 
		{
		structure.setMessage(" verify Student phone" );
		structure.setData(stu.get());
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}
		throw new InValidCredentialException();
  }
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student)
	{
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		Optional<Student> stu=dao.findById(student.getId());
		if(stu.isPresent())
		{
			Student s=stu.get();
			s.setId(student.getId());
			s.setName(student.getName());
			s.setEmail(student.getEmail());
			s.setPassword(student.getPassword());
			s.setPhone(student.getPhone());
			structure.setMessage("Student is Updated");
		    structure.setData(dao.saveStudent(s));
		    structure.setStatuscode(HttpStatus.ACCEPTED.value());
		    return new ResponseEntity<ResponseStructure<Student>> (structure, HttpStatus.ACCEPTED);
		}
		throw new InValidCredentialException();
	}
	public ResponseEntity<ResponseStructure<Boolean>> deleteById(int id)
	{
		ResponseStructure<Boolean> structure=new ResponseStructure<>();
		Optional<Student> stu=dao.findById(id);
		if(stu.isPresent())
		{
			structure.setMessage(" Delete Student id ");
			structure.setData(true);
			structure.setStatuscode(HttpStatus.NO_CONTENT.value());
			return new ResponseEntity<ResponseStructure<Boolean>> (structure, HttpStatus.NO_CONTENT);
		}
		throw new InValidCredentialException();
	}
}
