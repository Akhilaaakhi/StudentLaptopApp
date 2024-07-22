package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.dto.ResponseStructure;

@ControllerAdvice
public class StudentException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(InValidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> isEXEHandle(InValidCredentialException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData(e.getMessage());
		structure.setMessage("in valid credentials");
		structure.setStatuscode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NO_CONTENT);
	}

}
