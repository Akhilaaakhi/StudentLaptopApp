package com.example.demo.Exception;

public class InValidCredentialException extends RuntimeException
{
    public String getMessage()
    {
    	return "invalid Id";
    }
}
