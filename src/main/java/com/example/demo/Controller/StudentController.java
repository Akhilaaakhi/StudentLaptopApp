package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StudentService;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.dto.Student;

@RestController
@RequestMapping("/students")
public class StudentController 
{
	@Autowired
   private StudentService ser;
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student)
	{
		return ser.saveStudent(student);
	}
	@GetMapping("/")
	public ResponseEntity<ResponseStructure<Student>> findById(@RequestParam int id)
	{
		return ser.findById(id);
	}
	@GetMapping("/verifybyemail")
	public ResponseEntity<ResponseStructure<Student>> verifyByEmail(@RequestParam String email,@RequestParam String password)
	{
		return ser.verifyByEmail(email, password);
	}
	@GetMapping("/verifybyphone")
	public ResponseEntity<ResponseStructure<Student>> verifyByPhone(@RequestParam long phone, @RequestParam String password)
	{
		return ser.verifyByPhone(phone, password);
	}
	@PutMapping("/")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student)
	{
		return ser.updateStudent(student);
	}
	@DeleteMapping("/")
	public ResponseEntity<ResponseStructure<Boolean>> deleteById(@RequestParam int id)
	{
		return ser.deleteById(id);
	}
}
